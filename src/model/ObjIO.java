package src.model;

//import java.io.*;
import java.io.*;
import java.util.ArrayList;

public class ObjIO implements FileReadWrite {

    @Override
    public Serializable readFile(String aFileName) {   // throws IOException, ClassNotFoundException {
        Serializable aObj = null;
        // Востановление из файла с помощью класса ObjectInputStream

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName))) {
            aObj = (Serializable) objectInputStream.readObject();
//            System.out.println("Загрузка данных: успех !\nВаше семейное древо загружено !");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
//        ObjectInputStream objectInputStream = new ObjectInputStream(
//                new FileInputStream(aFileName));
//        aObj = (Serializable) objectInputStream.readObject();
//        objectInputStream.close();
        return aObj;
    }
    

    @Override
	public String writeFile(String aFileName, Serializable aObj){  // throws IOException, ClassNotFoundException
	    //Сериализация в файл с помощью класса ObjectOutputStream
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream(aFileName));
//        objectOutputStream.writeObject(aObj);
//        objectOutputStream.close();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName))) {
            objectOutputStream.writeObject(aObj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return aFileName;
	}

//    @Override
    public ArrayList<String> readFileTXT(String aFileName){  // throws IOException, ClassNotFoundException
        try {
            File path=new File(aFileName);
            String str;
            BufferedReader br = new BufferedReader(new FileReader(path));
            ArrayList<String> priorityArray = new ArrayList<>();

            while ((str = br.readLine()) != null){
                priorityArray.add(str);
            }
            br.close();
//            Debug
//            System.out.println("readFileTXT \n" + aFileName);
//            System.out.println(priorityArray.toString());
            return priorityArray;

        } catch (IOException e){
            System.out.println(e);
            return null;
        }
    }

    public String writeFileTXT(String aFileName, ArrayList<String> aL){  // throws IOException, ClassNotFoundException

        try {
            File path2=new File(aFileName);
            BufferedWriter bw=new BufferedWriter(new FileWriter(path2,true));
            String s;

            for(int k = 0; k < aL.size(); k++) {
                s = aL.get(k).toString();
                bw.write(s); bw.newLine();
            }
            bw.close();
            return aFileName;
        } catch (IOException e){
            System.out.println(e);
            return null;
        }
    }

    public String writeFileTXT(String aFileName, String aStr){  // throws IOException, ClassNotFoundException

        try {
            File path2=new File(aFileName);
            BufferedWriter bw=new BufferedWriter(new FileWriter(path2,false));  // append true
            bw.write(aStr); bw.newLine();
            bw.close();
            return aFileName;
        } catch (IOException e){
            System.out.println(e);
            return null;
        }
    }

}

