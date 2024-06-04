/* Copyright 2014 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.examples.pdmodel;
import java.io.IOException;
/**
 * This example creates a PDF with type 2 (axial) and type 3 (radial) shadings with a type 2
 * (exponential) function, and a type 4 (gouraud triangle shading) without function.
 *
 * @author Tilman Hausherr
 */
public class CreateGradientShadingPDF {
    /**
     * This will create the PDF and write the contents to a file.
     *
     * @param file
     * 		The name of the file to write to.
     * @throws IOException
     * 		If there is an error writing the data.
     */
    public void create(String file) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = null;
        try {
            document = new org.apache.pdfbox.pdmodel.PDDocument();
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            document.addPage(page);
            // type 2 (exponential) function with attributes
            // can be used by both shadings
            org.apache.pdfbox.cos.COSDictionary fdict = new org.apache.pdfbox.cos.COSDictionary();
            fdict.setInt(org.apache.pdfbox.cos.COSName.FUNCTION_TYPE, 2);
            org.apache.pdfbox.cos.COSArray domain = new org.apache.pdfbox.cos.COSArray();
            domain.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            domain.add(org.apache.pdfbox.cos.COSInteger.ONE);
            org.apache.pdfbox.cos.COSArray c0 = new org.apache.pdfbox.cos.COSArray();
            c0.add(org.apache.pdfbox.cos.COSInteger.ONE);
            c0.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            c0.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            org.apache.pdfbox.cos.COSArray c1 = new org.apache.pdfbox.cos.COSArray();
            c1.add(org.apache.pdfbox.cos.COSNumber.get("0.5"));
            c1.add(org.apache.pdfbox.cos.COSInteger.ONE);
            c1.add(org.apache.pdfbox.cos.COSNumber.get("0.5"));
            fdict.setItem(org.apache.pdfbox.cos.COSName.DOMAIN, domain);
            fdict.setItem(org.apache.pdfbox.cos.COSName.C0, c0);
            fdict.setItem(org.apache.pdfbox.cos.COSName.C1, c1);
            fdict.setInt(org.apache.pdfbox.cos.COSName.N, 1);
            org.apache.pdfbox.pdmodel.common.function.PDFunctionType2 func = new org.apache.pdfbox.pdmodel.common.function.PDFunctionType2(fdict);
            // axial shading with attributes
            org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2 axialShading = new org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2(new org.apache.pdfbox.cos.COSDictionary());
            axialShading.setColorSpace(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE);
            axialShading.setShadingType(org.apache.pdfbox.pdmodel.graphics.shading.PDShading.SHADING_TYPE2);
            org.apache.pdfbox.cos.COSArray coords1 = new org.apache.pdfbox.cos.COSArray();
            coords1.add(org.apache.pdfbox.cos.COSInteger.get(100));
            coords1.add(org.apache.pdfbox.cos.COSInteger.get(400));
            coords1.add(org.apache.pdfbox.cos.COSInteger.get(400));
            coords1.add(org.apache.pdfbox.cos.COSInteger.get(600));
            axialShading.setCoords(coords1);
            axialShading.setFunction(func);
            // radial shading with attributes
            org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType3 radialShading = new org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType3(new org.apache.pdfbox.cos.COSDictionary());
            radialShading.setColorSpace(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE);
            radialShading.setShadingType(org.apache.pdfbox.pdmodel.graphics.shading.PDShading.SHADING_TYPE3);
            org.apache.pdfbox.cos.COSArray coords2 = new org.apache.pdfbox.cos.COSArray();
            coords2.add(org.apache.pdfbox.cos.COSInteger.get(100));
            coords2.add(org.apache.pdfbox.cos.COSInteger.get(400));
            coords2.add(org.apache.pdfbox.cos.COSInteger.get(50));// radius1

            coords2.add(org.apache.pdfbox.cos.COSInteger.get(400));
            coords2.add(org.apache.pdfbox.cos.COSInteger.get(600));
            coords2.add(org.apache.pdfbox.cos.COSInteger.get(150));// radius2

            radialShading.setCoords(coords2);
            radialShading.setFunction(func);
            // Gouraud shading
            // See PDF 32000 specification,
            // 8.7.4.5.5 Type 4 Shadings (Free-Form Gouraud-Shaded Triangle Meshes)
            org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4 gouraudShading = new org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4(document.getDocument().createCOSStream());
            gouraudShading.setShadingType(org.apache.pdfbox.pdmodel.graphics.shading.PDShading.SHADING_TYPE4);
            // we use multiple of 8, so that no padding is needed
            gouraudShading.setBitsPerFlag(8);
            gouraudShading.setBitsPerCoordinate(16);
            gouraudShading.setBitsPerComponent(8);
            org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
            // coordinates x y map 16 bits 0..FFFF to 0..FFFF to make your life easy
            // so no calculation is needed, but you can only use integer coordinates
            // for real numbers, you'll need smaller bounds, e.g. 0xFFFF / 0xA = 0x1999
            // would allow 1 point decimal result coordinate.
            // See in PDF specification: 8.9.5.2 Decode Arrays
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.get(0xffff));
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.get(0xffff));
            // colors r g b map 8 bits from 0..FF to 0..1
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
            decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
            gouraudShading.setDecodeValues(decodeArray);
            gouraudShading.setColorSpace(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE);
            // Function is not required for type 4 shadings and not really useful,
            // because if a function would be used, each corner "color" of a triangle would be one value,
            // which would then transformed into n color components by the function so it is
            // difficult to get 3 "extremes".
            // fill the vertex stream
            java.io.OutputStream os = ((org.apache.pdfbox.cos.COSStream) (gouraudShading.getCOSObject())).createOutputStream();
            javax.imageio.stream.MemoryCacheImageOutputStream mcos = new javax.imageio.stream.MemoryCacheImageOutputStream(os);
            // Vertex 1, starts with flag1
            // (flags always 0 for vertices of start triangle)
            mcos.writeByte(0);
            // x1 y1 (left corner)
            mcos.writeShort(0);
            mcos.writeShort(0);
            // r1 g1 b1 (red)
            mcos.writeByte(0xff);
            mcos.writeByte(0);
            mcos.writeByte(0);
            // Vertex 2, starts with flag2
            mcos.writeByte(0);
            // x2 y2 (top corner)
            mcos.writeShort(100);
            mcos.writeShort(100);
            // r2 g2 b2 (green)
            mcos.writeByte(0);
            mcos.writeByte(0xff);
            mcos.writeByte(0);
            // Vertex 3, starts with flag3
            mcos.writeByte(0);
            // x3 y3 (right corner)
            mcos.writeShort(200);
            mcos.writeShort(0);
            // r3 g3 b3 (blue)
            mcos.writeByte(0);
            mcos.writeByte(0);
            mcos.writeByte(0xff);
            mcos.close();
            // outside stream MUST be closed as well, see javadoc of MemoryCacheImageOutputStream
            os.close();
            // invoke shading from content stream
            // compress parameter is set to false so that you can see the stream in a text editor
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
            contentStream.shadingFill(axialShading);
            contentStream.shadingFill(radialShading);
            contentStream.shadingFill(gouraudShading);
            contentStream.close();
            document.save(file);
            document.close();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    /**
     * This will create a blank document.
     *
     * @param args
     * 		The command line arguments.
     * @throws IOException
     * 		If there is an error writing the document data.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            CreateGradientShadingPDF.usage();
        } else {
            CreateGradientShadingPDF creator = new CreateGradientShadingPDF();
            creator.create(args[0]);
        }
    }

    /**
     * This will print the usage of this class.
     */
    private static void usage() {
        System.err.println(("usage: java " + CreateGradientShadingPDF.class.getName()) + " <outputfile.pdf>");
    }
}