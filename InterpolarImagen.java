//Esta es una pequeña modificación para ENTORNOS DE DESARROLLO: GIT.

/*---------------------------------------------*\
| IES Serra Perenxisa (Torrent)           |
| CFGS DAM Primer Curso.                        |
| MODULO: Programación                          |
| UNIDAD 3: Excepciones, bucles y arrays.       |
| ACTIVIDAD: Práctica opcional.                 |
| PROFESOR: José Rosa Rodríguez                 |
\*---------------------------------------------*/

// Nota1: si usas el código en un proyecto de Eclipse por ejemplo
//        no olvides añadir una sentencia package TalyTal;

// Nota2: si usas el código en un proyecto de Eclipse, debes modificar el fichero
//        module-info.java y añadir la sentencia:
//                require desktop.java;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class InterpolarImagen {
    static Image img = null;
    static BufferedImage biOrigen = null, biDestino = null;
    static JFileChooser jfc = null;
    static JScrollPane spImagen = null, spResultado;
    static JTextField tfSx= null, tfSy = null;
    static JRadioButton rbVecino = null;
    static JRadioButton rbLineal = null;
    static JRadioButton rbCubica = null;
    static float sX=1, sY=1;

    /**
     *  Genera una versión escalada de la imagen de entrada usando el método
     *  de interpolación del vecino más próximo.
     * @param imagen   la imagen a escalar. Una tabla de enteros con los pixels de la imagen.
     * @param sX       El factor de escalada horizontal
     * @param sY       El factor de escalado vertical
     * @return         una nueva table con los pixels de la nueva imagen
     */
    public static int[][] escalaVecino(int[][] imagen, float sX, float sY) {
        int[][] escalada = null;
        if(imagen == null) return escalada;
        // Escribe tu código....
        int nX = (int)(imagen[0].length*sX);
        int nY = (int)(imagen.length*sY);
        escalada = new int[nY][nX];
        int py, px;

        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                py = (int) Math.floor(i/sY);
                px = (int) Math.floor(j/sX);
                escalada[i][j] = imagen[py][px];
            }
        }

        return escalada;

    }

    /**
     *  Genera una versión escalada de la imagen de entrada usando el método
     *  de interpolación bilineal.
     * @param imagen   la imagen a escalar. Una tabla de enteros con los pixels de la imagen.
     * @param sX       El factor de escalada horizontal
     * @param sY       El factor de escalado vertical
     * @return         una nueva tabla con los pixels de la nueva imagen
     */
    public static int[][] escalaLineal(int[][] imagen, float sX, float sY) {
        int[][] escalada = null;
        if(imagen == null) return escalada;
        // Escribe tu código....
    
        return escalada;
    }

    /**
     *  Genera una versión escalada de la imagen de entrada usando el método
     *  de interpolación bicúbico.
     * @param imagen   la imagen a escalar. Una tabla de enteros con los pixels de la imagen.
     * @param sX       El factor de escalada horizontal
     * @param sY       El factor de escalado vertical
     * @return         una nueva table con los pixels de la nueva imagen
     */
    public static int[][] escalaCubico(int[][] imagen, float sX, float sY) {
        int[][] escalada = null;
        if(imagen == null) return escalada;
        // Escribe tu código....

        return escalada;
    }

    public static void main(String[]args) {
        JFrame ventana = new JFrame( "Escalar");
        ventana.setBounds(10,10,580,540);
        ventana.getContentPane().setLayout(null);
        jfc = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Imágenes", "jpg", "gif", "png");
        jfc.setFileFilter(imgFilter);
        jfc.setCurrentDirectory( new File( System.getProperty("user.dir") ) );
        JButton bAbrir = new JButton("Abrir imagen");
        bAbrir.setBounds(10,10, 150, 20);
        ventana.add(bAbrir);  
        bAbrir.addActionListener( (e) -> {      
                                      if( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {  
                                        try{
                                            biOrigen = ImageIO.read( jfc.getSelectedFile() );
                                            JLabel ilOrigen = new JLabel(new ImageIcon(biOrigen));
                                            spImagen.getViewport().setView(ilOrigen);
                                        } catch(IOException ioe){
                                             JOptionPane.showMessageDialog(null, ioe.getMessage());
                                        }  
                                      }
                                  }  
                                );
        JLabel l1 = new JLabel("Escala X");
        l1.setBounds(170, 14, 60, 15);
        ventana.add(l1);
        JLabel l2 = new JLabel("Escala Y");
        l2.setBounds(170, 38, 60, 15);
        ventana.add(l2);
        tfSx = new JTextField();
        tfSx.setBounds(225, 10, 35, 20);
        ventana.add(tfSx);
        tfSy = new JTextField();
        tfSy.setBounds(225, 34, 35, 20);
        ventana.add(tfSy);
        rbVecino = new JRadioButton("Vecino más próximo");
        rbVecino.setBounds(270, 10, 150, 20);
        rbLineal = new JRadioButton("Bilineal");
        rbLineal.setBounds(270, 30, 150, 20);
        rbCubica = new JRadioButton("Bicúbica");
        rbCubica.setBounds(270, 50, 150, 20);
        ButtonGroup bgGrupo = new ButtonGroup();
        bgGrupo.add(rbVecino);
        bgGrupo.add(rbLineal);
        bgGrupo.add(rbCubica);
        rbVecino.setSelected(true);
        ventana.add(rbVecino);
        ventana.add(rbLineal);
        ventana.add(rbCubica);  
        spImagen = new JScrollPane();
        spImagen.setBounds(10, 90, 150, 200);
        ventana.add(spImagen);
        spResultado = new JScrollPane();
        spResultado.setBounds(200, 90, 350, 400);
        ventana.add(spResultado);
        JButton bInterpolar = new JButton("Escalar");
        bInterpolar.setBounds(450,10, 100, 20);
        ventana.add(bInterpolar);  
        bInterpolar.addActionListener( (e) -> {      
                                      if( biOrigen == null ) return;
                                      try{
                                        sX = Float.parseFloat( tfSx.getText() );
                                        tfSx.setBackground(Color.white);
                                      } catch(Exception ex){
                                        tfSx.setBackground(Color.red);
                                        return;
                                      }
                                      try{
                                        sY = Float.parseFloat( tfSy.getText() );
                                        tfSy.setBackground(Color.white);
                                      } catch(Exception ex){
                                        tfSy.setBackground(Color.red);
                                        return;
                                      }  
                                      int filas = biOrigen.getHeight();
                                      int cols = biOrigen.getWidth();
                                      int[][] tablaImagen = new int[filas][cols];
                                      for(int i= 0; i < filas; i++){
                                        for(int j= 0; j < cols; j++){
                                            tablaImagen[i][j] = biOrigen.getRGB(j, i);
                                        }
                                      }
                                      int[][] tablaEscalada = null;
                                      if(rbVecino.isSelected())
                                          tablaEscalada = escalaVecino(tablaImagen, sX, sY);
                                      else if(rbLineal.isSelected())
                                          tablaEscalada = escalaLineal(tablaImagen, sX, sY);
                                      else tablaEscalada = escalaCubico(tablaImagen, sX, sY);        
                                      if(tablaEscalada == null) return;
                                      filas = tablaEscalada.length;
                                      cols = tablaEscalada[0].length;
                                      BufferedImage biResultado = new BufferedImage(cols, filas, BufferedImage.TYPE_INT_RGB);
                                      for(int i= 0; i < filas; i++){
                                        for(int j= 0; j < cols; j++){
                                            biResultado.setRGB(j, i, tablaEscalada[i][j]);
                                        }
                                      }  
                                      JLabel ilEscalado = new JLabel(new ImageIcon(biResultado));
                                            spResultado.getViewport().setView(ilEscalado);
                                  }  
                                );
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}