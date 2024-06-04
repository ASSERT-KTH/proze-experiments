/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.rendering;
import java.io.IOException;
/**
 * Test suite for rendering.
 *
 * FILE SET VALIDATION
 *
 * This test is designed to test PDFToImage using a set of PDF files and known good output for
 * each. The default mode is to process all *.pdf and *.ai files in
 * "src/test/resources/input/rendering". An output file is created in "target/test-output/rendering"
 * with the same name as the PDF file, plus an additional page number and ".png" suffix.
 *
 * The output file is then tested against a known good result file from the input directory (again,
 * with the same name as the tested PDF file, but with the additional page number and ".png"
 * suffix).
 *
 * If the two aren't identical, a graphical .diff.png file is created. If they are identical, the
 * output .png file is deleted. If a "good result" file doesn't exist, the output .png file is left
 * there for human inspection.
 *
 * Errors are flagged by creating empty files with appropriate names in the target directory.
 *
 * @author Daniel Wilson
 * @author Ben Litchfield
 * @author Tilman Hausherr
 */
public class TestPDFToImage {
    /**
     * Logger instance.
     */
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(TestPDFToImage.class);

    static String inDir = "src/test/resources/input/rendering";

    static String outDir = "target/test-output/rendering/";

    String filename;

    /**
     * Test class constructor.
     *
     * @param filename
     * 		The name of the test class.
     * @throws IOException
     * 		If there is an error creating the test.
     */
    public TestPDFToImage(String filename) throws IOException {
        this.filename = filename;
    }

    /**
     * Create an image; the part between the smaller and the larger image is painted black, the rest
     * in white
     *
     * @param minWidth
     * 		width of the smaller image
     * @param minHeight
     * 		width of the smaller image
     * @param maxWidth
     * 		height of the larger image
     * @param maxHeight
     * 		height of the larger image
     * @return  */
    private java.awt.image.BufferedImage createEmptyDiffImage(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        java.awt.image.BufferedImage bim3 = new java.awt.image.BufferedImage(maxWidth, maxHeight, java.awt.image.BufferedImage.TYPE_INT_RGB);
        java.awt.Graphics graphics = bim3.getGraphics();
        if ((minWidth != maxWidth) || (minHeight != maxHeight)) {
            graphics.setColor(java.awt.Color.BLACK);
            graphics.fillRect(0, 0, maxWidth, maxHeight);
        }
        graphics.setColor(java.awt.Color.WHITE);
        graphics.fillRect(0, 0, minWidth, minHeight);
        graphics.dispose();
        return bim3;
    }

    /**
     * Get the difference between two images, identical colors are set to white, differences are
     * xored, the highest bit of each color is reset to avoid colors that are too light.
     *
     * @param bim1
     * @param bim2
     * @return If the images are different, the function returns a diff image. If the images are
    identical, the function returns null. If the size is different, a black border on the bottom
    at the right is created.
     * @throws IOException
     */
    private java.awt.image.BufferedImage diffImages(java.awt.image.BufferedImage bim1, java.awt.image.BufferedImage bim2) throws IOException {
        int minWidth = Math.min(bim1.getWidth(), bim2.getWidth());
        int minHeight = Math.min(bim1.getHeight(), bim2.getHeight());
        int maxWidth = Math.max(bim1.getWidth(), bim2.getWidth());
        int maxHeight = Math.max(bim1.getHeight(), bim2.getHeight());
        java.awt.image.BufferedImage bim3 = null;
        if ((minWidth != maxWidth) || (minHeight != maxHeight)) {
            bim3 = createEmptyDiffImage(minWidth, minHeight, maxWidth, maxHeight);
        }
        for (int x = 0; x < minWidth; ++x) {
            for (int y = 0; y < minHeight; ++y) {
                int rgb1 = bim1.getRGB(x, y);
                int rgb2 = bim2.getRGB(x, y);
                if ((rgb1 != rgb2) && // don't bother about small differences
                (((Math.abs((rgb1 & 0xff) - (rgb2 & 0xff)) > 3) || (Math.abs(((rgb1 >> 8) & 0xff) - ((rgb2 >> 8) & 0xff)) > 3)) || (Math.abs(((rgb1 >> 16) & 0xff) - ((rgb2 >> 16) & 0xff)) > 3))) {
                    if (bim3 == null) {
                        bim3 = createEmptyDiffImage(minWidth, minHeight, maxWidth, maxHeight);
                    }
                    int r = Math.abs((rgb1 & 0xff) - (rgb2 & 0xff));
                    int g = Math.abs((rgb1 & 0xff00) - (rgb2 & 0xff00));
                    int b = Math.abs((rgb1 & 0xff0000) - (rgb2 & 0xff0000));
                    bim3.setRGB(x, y, 0xffffff - ((r | g) | b));
                } else if (bim3 != null) {
                    bim3.setRGB(x, y, java.awt.Color.WHITE.getRGB());
                }
            }
        }
        return bim3;
    }

    /**
     * Validate the renderings of a single file.
     *
     * @param file
     * 		The file to validate
     * @param inDir
     * 		Name of the input directory
     * @param outDir
     * 		Name of the output directory
     * @return false if the test failed (not identical or other problem), true if the test succeeded
    (all identical)
     * @throws IOException
     * 		when there is an exception
     */
    public boolean doTestFile(final java.io.File file, String inDir, String outDir) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = null;
        boolean failed = false;
        TestPDFToImage.LOG.info("Opening: " + file.getName());
        try {
            new java.io.FileOutputStream(new java.io.File(outDir, file.getName() + ".parseerror")).close();
            document = org.apache.pdfbox.pdmodel.PDDocument.load(file, ((String) (null)));
            String outputPrefix = ((outDir + '/') + file.getName()) + "-";
            int numPages = document.getNumberOfPages();
            if (numPages < 1) {
                failed = true;
                TestPDFToImage.LOG.error(("file " + file.getName()) + " has < 1 page");
            } else {
                new java.io.File(outDir, file.getName() + ".parseerror").delete();
            }
            TestPDFToImage.LOG.info("Rendering: " + file.getName());
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < numPages; i++) {
                String fileName = (outputPrefix + (i + 1)) + ".png";
                new java.io.FileOutputStream(new java.io.File(fileName + ".rendererror")).close();
                java.awt.image.BufferedImage image = renderer.renderImageWithDPI(i, 96);// Windows native DPI

                new java.io.File(fileName + ".rendererror").delete();
                TestPDFToImage.LOG.info("Writing: " + fileName);
                new java.io.FileOutputStream(new java.io.File(fileName + ".writeerror")).close();
                javax.imageio.ImageIO.write(image, "PNG", new java.io.File(fileName));
                new java.io.File(fileName + ".writeerror").delete();
            }
            // test to see whether file is destroyed in pdfbox
            new java.io.FileOutputStream(new java.io.File(outDir, file.getName() + ".saveerror")).close();
            java.io.File tmpFile = java.io.File.createTempFile("pdfbox", ".pdf");
            document.setAllSecurityToBeRemoved(true);
            document.save(tmpFile);
            new java.io.File(outDir, file.getName() + ".saveerror").delete();
            new java.io.FileOutputStream(new java.io.File(outDir, file.getName() + ".reloaderror")).close();
            org.apache.pdfbox.pdmodel.PDDocument.load(tmpFile, ((String) (null))).close();
            new java.io.File(outDir, file.getName() + ".reloaderror").delete();
            tmpFile.delete();
        } catch (IOException e) {
            failed = true;
            TestPDFToImage.LOG.error("Error converting file " + file.getName());
            throw e;
        } finally {
            if (document != null) {
                document.close();
            }
        }
        TestPDFToImage.LOG.info("Comparing: " + file.getName());
        // Now check the resulting files ... did we get identical PNG(s)?
        try {
            new java.io.File((outDir + file.getName()) + ".cmperror").delete();
            java.io.File[] outFiles = new java.io.File(outDir).listFiles(new java.io.FilenameFilter() {
                @Override
                public boolean accept(java.io.File dir, String name) {
                    return (name.endsWith(".png") && name.startsWith(file.getName(), 0)) && (!name.endsWith(".png-diff.png"));
                }
            });
            if (outFiles.length == 0) {
                failed = true;
                TestPDFToImage.LOG.warn("*** TEST FAILURE *** Output missing for file: " + file.getName());
            }
            for (java.io.File outFile : outFiles) {
                new java.io.File(outFile.getAbsolutePath() + "-diff.png").delete();// delete diff file from a previous run

                java.io.File inFile = new java.io.File((inDir + '/') + outFile.getName());
                if (!inFile.exists()) {
                    failed = true;
                    TestPDFToImage.LOG.warn("*** TEST FAILURE *** Input missing for file: " + inFile.getName());
                } else if (!filesAreIdentical(outFile, inFile)) {
                    // different files might still have identical content
                    // save the difference (if any) into a diff image
                    java.awt.image.BufferedImage bim3 = diffImages(javax.imageio.ImageIO.read(inFile), javax.imageio.ImageIO.read(outFile));
                    if (bim3 != null) {
                        failed = true;
                        TestPDFToImage.LOG.warn("*** TEST FAILURE *** Input and output not identical for file: " + inFile.getName());
                        javax.imageio.ImageIO.write(bim3, "png", new java.io.File(outFile.getAbsolutePath() + "-diff.png"));
                        System.err.println(((("Files differ: " + inFile.getAbsolutePath()) + "\n") + "              ") + outFile.getAbsolutePath());
                    } else {
                        TestPDFToImage.LOG.info("*** TEST OK *** for file: " + inFile.getName());
                        TestPDFToImage.LOG.info("Deleting: " + outFile.getName());
                        outFile.delete();
                        outFile.deleteOnExit();
                    }
                } else {
                    TestPDFToImage.LOG.info("*** TEST OK *** for file: " + inFile.getName());
                    TestPDFToImage.LOG.info("Deleting: " + outFile.getName());
                    outFile.delete();
                    outFile.deleteOnExit();
                }
            }
        } catch (Exception e) {
            new java.io.FileOutputStream(new java.io.File(outDir, file.getName() + ".cmperror")).close();
            failed = true;
            TestPDFToImage.LOG.error("Error comparing file output for " + file.getName(), e);
        }
        return !failed;
    }

    private boolean filesAreIdentical(java.io.File left, java.io.File right) throws IOException {
        // http://forum.java.sun.com/thread.jspa?threadID=688105&messageID=4003259
        // http://web.archive.org/web/20060515173719/http://forum.java.sun.com/thread.jspa?threadID=688105&messageID=4003259
        /* -- I reworked ASSERT's into IF statement -- dwilson
        assert left != null;
        assert right != null;
        assert left.exists();
        assert right.exists();
         */
        if ((((left != null) && (right != null)) && left.exists()) && right.exists()) {
            if (left.length() != right.length()) {
                return false;
            }
            java.io.FileInputStream lin = new java.io.FileInputStream(left);
            java.io.FileInputStream rin = new java.io.FileInputStream(right);
            try {
                byte[] lbuffer = new byte[4096];
                byte[] rbuffer = new byte[lbuffer.length];
                int lcount;
                while ((lcount = lin.read(lbuffer)) > 0) {
                    int bytesRead = 0;
                    int rcount;
                    while ((rcount = rin.read(rbuffer, bytesRead, lcount - bytesRead)) > 0) {
                        bytesRead += rcount;
                    } 
                    for (int byteIndex = 0; byteIndex < lcount; byteIndex++) {
                        if (lbuffer[byteIndex] != rbuffer[byteIndex]) {
                            return false;
                        }
                    }
                } 
            } finally {
                lin.close();
                rin.close();
            }
            return true;
        } else {
            return false;
        }
    }
}