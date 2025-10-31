/*import java.io.*;

public class Archivo {

    private File f;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;

    //Método para leer archivo
    public List readList() {

        List list = new List();
        String record, fields[];
        // paso 1
        f = new File("contacts.txt");
        try {
            // paso 2
            fr = new FileReader(f);
            // paso 3
            br = new BufferedReader(fr);
            // paso 4
            while((record = br.readLine())!= null) {
                fields = record.split("\n");
                Contact ct = new  Contact(fields[0], fields[1], Integer.parseInt(fields[2]), fields[3],
                        Boolean.parseBoolean(fields[4]));
                list.AddLast(ct);
            }
            //paso 5
            br.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Método para escribir archivo
    public void writeList(List list) {

        f = new File("contacts.txt");
        try {

            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            Node aux = list.getHead();
            while(aux != null) {
                Contact ct = (Contact)aux.getData();
                bw.write(ct.getId() +"\t" + ct.getName() +"\t" +
                        ct.getPhone() +"\t" + ct.getEmail() +"\t" +
                        ct.isState() +"\n");
                aux = aux.getLink();
            }
            bw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}*/
