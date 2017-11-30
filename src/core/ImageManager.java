package core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by nagatea on 2017/12/01.
 */
public class ImageManager {
    HashMap<String, BufferedImage> imageList;
    public ImageManager(){
        imageList = new HashMap<>();
    }

    public BufferedImage load(String uri){
        if(imageList.containsKey(uri)){
            return imageList.get(uri);
        }
        BufferedImage image;
        try{
            image = ImageIO.read(new File(uri));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        imageList.put(uri, image);
        return image;
    }

    public BufferedImage[] load(String[] uris){
        Vector<BufferedImage> images = new Vector<>();
        for(String uri: uris) {
            if (imageList.containsKey(uri)) {
                images.add(imageList.get(uri));
                continue;
            }
            BufferedImage image;
            try {
                image = ImageIO.read(new File(uri));
            } catch (IOException e) {
                e.printStackTrace();
                image = null;
            }
            imageList.put(uri, image);
            images.add(image);
        }
        return (BufferedImage[])images.toArray();
    }

    public HashMap<String, BufferedImage> load(HashMap<String, String> map){
        HashMap<String, BufferedImage> imageHashMap = new HashMap<>();
        for(HashMap.Entry<String, String> e: map.entrySet()){
            if(imageList.containsKey(e.getKey())){
                imageHashMap.put(e.getValue(), imageList.get(e.getKey()));
                continue;
            }
            BufferedImage image;
            try{
                image = ImageIO.read(new File(e.getKey()));
            } catch (IOException exception){
                exception.printStackTrace();
                image = null;
            }
            imageList.put(e.getKey(), image);
            imageHashMap.put(e.getValue(), image);
        }
        return imageHashMap;
    }

}
