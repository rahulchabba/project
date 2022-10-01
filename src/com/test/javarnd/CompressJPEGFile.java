/*
package com.test.javarnd;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfImageObject;
public class CompressJPEGFile {
    public static float FACTOR = 0.5f;

    public static void main(String[] args) throws IOException, DocumentException {
        String path = ".\\";
        System.out.println("Yogi Directory BTAO ??? Path BTAO = ");
        Scanner pathSc = new Scanner(System.in);
        String inputpath = pathSc.nextLine();
        if (!inputpath.isEmpty() && !inputpath.equals(" ")) {
            if (inputpath.endsWith("\\")) {
                path = inputpath;
            } else {
                path = inputpath + File.separator;
            }

        }

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.println("Enter value 1 - 10");
        Scanner qualitySc = new Scanner(System.in);
        int value = qualitySc.nextInt() % 10;
        float quality = 0.1f * value;  // 0.1 - 1.0
        FACTOR = quality;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && !listOfFiles[i].getName().endsWith(".jar") && !listOfFiles[i].getName().endsWith(".bat") && !listOfFiles[i].getName().endsWith(".pdf")) {
                String name = listOfFiles[i].getName();
                // String fileExtenstion = FilenameUtils.getExtension(name);
                compress(path, name, "jpg", quality);
            } else if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".pdf")) {
                String name = listOfFiles[i].getName();
                manipulatePdf(path+name, path+"copy_"+name);
            }

        }


    }

    private static void compress(String path, String name, String fileExtenstion, float quality) throws IOException {
        File imageFile = new File(path + name);
        File compressedImageFile = new File(path + "copy_" + name);
        InputStream is = new FileInputStream(imageFile);
        OutputStream os = new FileOutputStream(compressedImageFile);
        // create a BufferedImage as the result of decoding the supplied InputStream
        BufferedImage image = ImageIO.read(is);

        // get all image writers for JPG format
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(fileExtenstion);

        if (!writers.hasNext())
            throw new IllegalStateException("No writers found");

        ImageWriter writer = writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        // compress to a given quality
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);

        // appends a complete image stream containing a single image and
        //associated stream and image metadata and thumbnails to the output
        writer.write(null, new IIOImage(image, null, null), param);

        // close all streams
        is.close();
        os.close();
        ios.close();
        writer.dispose();
        System.out.println("File converted :" + path + name);
    }

    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfName key = new PdfName("ITXT_SpecialId");
        PdfName value = new PdfName("123456789");
        // Read the file
        PdfReader reader = new PdfReader(src);
        int n = reader.getXrefSize();
        PdfObject object;
        PRStream stream;
        // Look for image and manipulate image stream
        for (int i = 0; i < n; i++) {
            object = reader.getPdfObject(i);
            if (object == null || !object.isStream())
                continue;
            stream = (PRStream)object;
            PdfObject pdfsubtype = stream.get(PdfName.SUBTYPE);
            if (pdfsubtype != null && pdfsubtype.toString().equals(PdfName.IMAGE.toString())) {
                PdfImageObject image = new PdfImageObject(stream);
                BufferedImage bi = image.getBufferedImage();
                if (bi == null) continue;
                int width = (int)(bi.getWidth() * FACTOR);
                int height = (int)(bi.getHeight() * FACTOR);
                BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                AffineTransform at = AffineTransform.getScaleInstance(FACTOR, FACTOR);
                Graphics2D g = img.createGraphics();
                g.drawRenderedImage(bi, at);
                ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
                ImageIO.write(img, "JPG", imgBytes);
                stream.clear();
                stream.setData(imgBytes.toByteArray(), false, PRStream.BEST_COMPRESSION);
                stream.put(PdfName.TYPE, PdfName.XOBJECT);
                stream.put(PdfName.SUBTYPE, PdfName.IMAGE);
                stream.put(key, value);
                stream.put(PdfName.FILTER, PdfName.DCTDECODE);
                stream.put(PdfName.WIDTH, new PdfNumber(width));
                stream.put(PdfName.HEIGHT, new PdfNumber(height));
                stream.put(PdfName.BITSPERCOMPONENT, new PdfNumber(8));
                stream.put(PdfName.COLORSPACE, PdfName.DEVICERGB);
            }
        }
        // Save altered PDF
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
        System.out.println("File converted :" + src);
    }


}
*/
