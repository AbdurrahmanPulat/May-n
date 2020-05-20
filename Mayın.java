
package mineesweeper;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mayın extends javax.swing.JFrame {
  final int en=9,boy=9,bombasayısı=10;
  JToggleButton [][] bloklar =new JToggleButton[boy][en];
  int [][] blok =new int[boy][en];
  boolean birinci,oyna;
  
  ActionListener listen =new ActionListener(){
      public void actionPerformed(ActionEvent e){
          int i =0,j=0;
          boolean found =false;
          for ( i = 0; i < boy; i++) {             
               for (j = 0; j < en; j++) {
                   if(e.getSource()==bloklar [i][j]){
                       found =true;
                       break;
                   }
          
           }
               if(found) break;      
          }
            if(oyna){
                bloklar [i][j].setSelected(true);
                if(!birinci){
                    spawn (i,j);
                    birinci = true;
                }
                if(blok[i][j] != -1){
                    acik(i,j);
                    deger();
                } else kaybetme();
                kazanma();
            }else deger();
            
      }
  };
  private void kazanma(){
      boolean kazandi =true;
      for (int i = 0; i < boy; i++) {
          for (int j = 0; j < en; j++) {
              if (blok[i][j] == 0){
                  kazandi=false;
                  break;
              }
          }
          if(!kazandi){
              break;
          }
          if(kazandi){
              javax.swing.JOptionPane.showMessageDialog(null,"KAZANDINIZ!");
              oyna=false;
          }
          
      }
  }
  private void kaybetme(){
      oyna = false;
      for (int i = 0; i < boy; i++) {
          for (int j = 0; j < en; j++) {
              if(blok[i][j] == -1){
                  bloklar[i][j].setText("MAYIN");
                  bloklar[i][j].setSelected(true);
              }
              
          }
          
      }
      
  }
  private void acik(int y ,int x){
      if(y<0 || x<0 || x > en -1 || y > boy -1 || blok[y][x] != 0) return;
      int bombalar = 0;
      for (int i = y-1; i <= y+1; i++) {
          for (int j = x-1; j <= x+1; j++) {
              if(!(j<0 || i<0 || j > en - 1 || i > boy -1 )&& blok[i][j] == -1)
                  bombalar++;
              
          }
          
      }
      if(bombalar ==0){
          blok [y][x]= -2; 
          for (int i = y-1; i <= y+1; i++) {
                for (int j = x-1; j <= x+1; j++) {
                    if(!(j<0 || i<0 || j > en - 1 || i > boy -1 ))
                    if(i != y || j != x) acik(i,j); 
                     
                }
          }
      }else blok [y][x]= bombalar ; 
  }
  
  private void deger(){
      for (int i = 0; i < boy; i++) {
          for (int j = 0; j < en; j++) {
              if(blok[i][j] == 0){
                  bloklar [i][j].setText("");
                  bloklar [i][j].setSelected(false);
              }
              if(blok[i][j] == -2){
                  bloklar [i][j].setText("");
                  bloklar [i][j].setSelected(true);
              }
              if(blok [i][j] > 0){
                   bloklar [i][j].setText(""+blok[i][j]);
                   bloklar [i][j].setSelected(true);
              }
              if(!oyna && blok[i][j] == -1){
                  bloklar[i][j].setSelected(true);
                  
              }
          }
          
      }
      jPanel1.repaint();
  }
  private void spawn(int y,int x){
      for (int k = 0; k <= bombasayısı; k++) {
          int i , j;
          do{
               i = (int)(Math.random()*en-.01);
               j = (int)(Math.random()*boy-.01);
          }
          while(blok[i][j] ==-1 || (i == y && j== x));
          blok [i][j]=-1;
   }
      
  }
   
    public Mayın() {
        initComponents();
        for(int i=0;i < boy;i++){
            for(int j=0;j < boy;j++){
                bloklar [i][j]=new JToggleButton();
                bloklar[i][j].setSize(jPanel1.getWidth()/en,jPanel1.getHeight()/boy);
                jPanel1.add(bloklar[i][j]);
                bloklar[i][j].setLocation(j*jPanel1.getWidth()/en,i*jPanel1.getHeight()/boy);
                bloklar [i][j].addActionListener(listen);
                
            }
        }
        birinci =false;
        oyna=true;
        
    }
    
    private void boyutlandırma(){
         for(int i=0;i < boy;i++){
            for(int j=0;j < boy;j++){
                bloklar[i][j].setSize(jPanel1.getWidth()/en,jPanel1.getHeight()/boy);
                jPanel1.add(bloklar[i][j]);
                bloklar[i][j].setLocation(j*jPanel1.getWidth()/en,i*jPanel1.getHeight()/boy);
                
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jMenu1.setText("OYUN");

        jMenuItem1.setText("Yeni Oyun");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Başlangıç Seviyesi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Normal Seviye");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Uzman Seviyesi");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Çıkış");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentMoved

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        boyutlandırma();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        blok = new int [boy][en];
        deger();
        oyna=true;
        birinci=false;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        blok = new int [boy][en];
        deger();
        oyna=true;
        birinci=false;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int en=40,boy=40,bombasayisi=40;
        JToggleButton [][] bloklar =new JToggleButton[boy][en];
        blok = new int [boy][en];
        deger();
        oyna=true;
        birinci=false;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mayın().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
