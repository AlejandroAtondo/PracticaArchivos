import java.io.*;

public class MatrizProducto {
    //Atondo Ojeda Darío Alejandro
    public static void main(String[] args) throws IOException {

        String archivoA = "src\\a.mat";

        DataInputStream lectorA = new DataInputStream(new FileInputStream(archivoA)); //se abre el lector
        int lineA = lectorA.readByte(); //se leen los bytes y se almacenan las lineas y columnas
        int columnA = lectorA.readByte();
        double mA[][] = new double[lineA][columnA]; //se crea la primera matriz

        for (int i = 0; i < lineA; i++) { //se almacena la matriz A
            for (int j = 0; j < columnA; j++) {
                mA[i][j] = lectorA.readDouble();
            }
        }

        String archivoB = "src\\b.mat";

        DataInputStream lectorB = new DataInputStream(new FileInputStream(archivoB)); //se abre el lector
        int lineB = lectorB.readByte(); //se leen los bytes y se almacenan las lineas y columnas
        int columnB = lectorB.readByte();
        double mB[][] = new double [lineB][columnB]; //se crea la segunda matriz

        for (int i = 0; i < lineB; i++) { //se almacena la matriz B
            for (int j = 0; j < columnB; j++) {
                mB[i][j] = lectorB.readDouble();
            }
        }

        double mC[][] = new double[lineA][columnB];
        for (int i = 0; i < lineA; i++) { //se genera el producto de matrices
            for (int j = 0; j < columnB; j++) {
                for (int k = 0; k < columnA; k++) {
                    mC[i][j] += mA[i][k] * mB[k][j];

                }
            }
        }

        //creación del último archivo
        String archivoC = "src\\c.mat";
        DataOutputStream escritor = new DataOutputStream(new FileOutputStream(archivoC)); //se abre el escritor
        escritor.write(lineA);
        escritor.write(columnB);
        for (int i = 0; i < lineA; i++) { //se escribe la matriz producto en el archivo c.mat
            for (int j = 0; j < columnB; j++) {
                escritor.writeDouble(mC[i][j]);
            }
        }

        escritor.close();
    }
}
