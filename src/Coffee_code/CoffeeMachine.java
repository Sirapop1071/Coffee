
package Coffee_code;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Sirapop
 */
public class CoffeeMachine extends JFrame {

    static final int ESPRESSO_WATER_ML_PER_CUP = 250;
    static final int ESPRESSO_MILK_ML_PER_CUP = 0;
    static final int ESPRESSO_BEANS_G_PER_CUP = 16;
    static final int ESPRESSO_PRICE = 35;
    static final int LATTE_WATER_ML_PER_CUP = 350;
    static final int LATTE_MILK_ML_PER_CUP = 75;
    static final int LATTE_BEANS_G_PER_CUP = 20;
    static final int LATTE_PRICE = 55;
    static final int CAPPUCCINO_WATER_ML_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_ML_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_G_PER_CUP = 12;
    static final int CAPPUCCINO_PRICE = 40;
    private int water = 2000;
    private int milk = 500;
    private int beans = 500;
    private int cups = 10;
    private int cash = 0;

    CoffeeMachine(int water, int milk, int beans, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cash = cash;
    }

    boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }

    public void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (canMakeCoffee(waterNeeded, milkNeeded, beansNeeded)) {
            lbPro.setText("I have enough resources! ");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups--;
            cash += price;
            txtPrice.setText("" + cash);
            txtWater.setText("" + water);
            txtCups.setText("" + cups);
            txtMilk.setText("" + milk);
            txtBeans.setText("" + beans);
        } else {
            if (water < waterNeeded) {
                Water.setForeground(Color.RED);
            } else if (milk < milkNeeded) {
                Milk.setForeground(Color.RED);
            } else if (beans < beansNeeded) {
                Beans.setForeground(Color.RED);
            } else if (cups <= 0) {
                Cups.setForeground(Color.RED);
            }
            lbPro.setText("Sorry, not enough resources! ");
        }
    }

    public void makeEspresso() {
        makeCoffee(ESPRESSO_WATER_ML_PER_CUP,
                ESPRESSO_MILK_ML_PER_CUP,
                ESPRESSO_BEANS_G_PER_CUP,
                ESPRESSO_PRICE);
    }

    public void makeLatte() {
        makeCoffee(LATTE_WATER_ML_PER_CUP,
                LATTE_MILK_ML_PER_CUP,
                LATTE_BEANS_G_PER_CUP,
                LATTE_PRICE);
    }

    public void makeCappuccino() {
        makeCoffee(CAPPUCCINO_WATER_ML_PER_CUP,
                CAPPUCCINO_MILK_ML_PER_CUP,
                CAPPUCCINO_BEANS_G_PER_CUP,
                CAPPUCCINO_PRICE);
    }

    public CoffeeMachine() {
        initComponents();
    }

    public void initComponents() {

        panelHome = new JPanel();
        frame = new JFrame();
        CoffeeShop = new JLabel();
        radEs = new JRadioButton();
        radLa = new JRadioButton();
        radCap = new JRadioButton();
        jPanel1 = new JPanel();
        Beans = new JLabel();
        Cups = new JLabel();
        Water = new JLabel();
        Milk = new JLabel();
        txtMilk = new JTextField();
        txtWater = new JTextField();
        txtCups = new JTextField();
        txtBeans = new JTextField();
        Fill = new JLabel();
        bAdd = new JButton();
        bCheck = new JButton();
        lbPro = new JLabel();
        bAddtocart = new JButton();
        bMore = new JButton();
        jLabel1 = new JLabel();
        lbcapu = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        bBuy = new JButton();
        txtPrice = new JTextField();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelHome.setBackground(new Color(255, 204, 153));

        CoffeeShop.setFont(new Font("Lucida Calligraphy", 1, 48)); // NOI18N
        CoffeeShop.setText("Coffee Shop");

        radEs.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        radEs.setText("ESPRESSO");
        radEs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radEsActionPerformed(evt);
            }
        });

        radLa.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        radLa.setText("LATTE");
        radLa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radLaActionPerformed(evt);
            }
        });

        radCap.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        radCap.setText("CAPPUCCINO");
        radCap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radCapActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new Color(255, 255, 255));

        Beans.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        Beans.setText("Beans");

        Cups.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        Cups.setText("Cups");

        Water.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        Water.setText("Water");

        Milk.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        Milk.setText("Milk");

        txtMilk.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        txtMilk.setEnabled(false);

        txtWater.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        txtWater.setEnabled(false);

        txtCups.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        txtCups.setEnabled(false);

        txtBeans.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        txtBeans.setEnabled(false);

        Fill.setFont(new Font("Leelawadee UI", 1, 24)); // NOI18N
        Fill.setText("Fill");

        bAdd.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        bAdd.setText("Add");
        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bCheck.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        bCheck.setText("Check");
        bCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Fill)
                                                        .addComponent(Milk))
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(bAdd,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        17, Short.MAX_VALUE)
                                                                .addComponent(bCheck))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(56, 56, 56)
                                                                .addComponent(txtMilk,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Beans)
                                                        .addComponent(Water)
                                                        .addComponent(Cups))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtWater)
                                                        .addComponent(txtBeans, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                57, Short.MAX_VALUE)
                                                        .addComponent(txtCups, javax.swing.GroupLayout.DEFAULT_SIZE, 57,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bAdd)
                                        .addComponent(Fill)
                                        .addComponent(bCheck))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Milk)
                                        .addComponent(txtMilk, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Water)
                                        .addComponent(txtWater, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Cups)
                                        .addComponent(txtCups, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Beans)
                                        .addComponent(txtBeans, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        lbPro.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        lbPro.setText("-----------");

        bAddtocart.setFont(new Font("Leelawadee UI", 1, 24)); // NOI18N
        bAddtocart.setText("Add to cart");
        bAddtocart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAddtocartActionPerformed(evt);
            }
        });

        bMore.setFont(new Font("Leelawadee UI", 1, 24)); // NOI18N
        bMore.setText("Select More....");
        bMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bMoreActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Coffee_code/png1.png"))); // NOI18N

        lbcapu.setFont(new Font("Leelawadee UI", 1, 12)); // NOI18N
        lbcapu.setText("Water 200 Milk 100 Beans 12 Price 40");

        jLabel3.setFont(new Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel3.setText("Water 250 Milk 0 Beans 16 Price 35");

        jLabel4.setFont(new Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel4.setText("Water 350 Milk 75 Beans 20 Price 55");

        bBuy.setFont(new Font("Leelawadee UI", 1, 24)); // NOI18N
        bBuy.setText("Buy");
        bBuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bBuyActionPerformed(evt);
            }
        });

        txtPrice.setFont(new Font("Leelawadee UI", 1, 14)); // NOI18N
        txtPrice.setEnabled(false);

        jLabel5.setFont(new Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel5.setText("Price");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
                panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
                                                        Short.MAX_VALUE)
                                                .addComponent(CoffeeShop, javax.swing.GroupLayout.PREFERRED_SIZE, 339,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                .addComponent(lbPro)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout
                                                .createSequentialGroup()
                                                .addGroup(panelHomeLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                                .addComponent(bMore,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                                .addGroup(panelHomeLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(radCap)
                                                                        .addComponent(radEs)
                                                                        .addComponent(radLa)
                                                                        .addComponent(bAddtocart)
                                                                        .addComponent(lbcapu)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addGroup(panelHomeLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panelHomeLayout
                                                                                .createSequentialGroup()
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jPanel1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(panelHomeLayout
                                                                                .createSequentialGroup()
                                                                                .addGap(92, 92, 92)
                                                                                .addComponent(jLabel5)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(panelHomeLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(bBuy)
                                                                                                .addGap(0, 0,
                                                                                                        Short.MAX_VALUE))
                                                                                        .addComponent(txtPrice))))))
                                                .addGap(25, 25, 25)))));
        panelHomeLayout.setVerticalGroup(
                panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(CoffeeShop)
                                                .addComponent(jLabel1))
                                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(radCap)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbcapu)
                                                .addGap(18, 18, 18)
                                                .addComponent(radEs)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addGap(20, 20, 20)
                                                .addComponent(radLa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4))
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23)
                                .addComponent(lbPro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                panelHomeLayout.createSequentialGroup()
                                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(15, 15, 15))
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                                .addGroup(panelHomeLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bAddtocart,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(
                                        panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bMore, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public void radCapActionPerformed(ActionEvent evt) {
        if (radCap.isSelected())
            radEs.setSelected(false);
        radLa.setSelected(false);
    }

    public void radEsActionPerformed(ActionEvent evt) {
        if (radEs.isSelected())
            radCap.setSelected(false);
        radLa.setSelected(false);
    }

    public void radLaActionPerformed(ActionEvent evt) {
        if (radLa.isSelected())
            radEs.setSelected(false);
        radCap.setSelected(false);
    }

    public void bAddtocartActionPerformed(ActionEvent evt) {
        if (radCap.isSelected()) {
            makeCappuccino();
        } else if (radEs.isSelected()) {
            makeEspresso();
        } else if (radLa.isSelected()) {
            makeLatte();
        }
    }

    public void bMoreActionPerformed(ActionEvent evt) {
        lbPro.setText("-------");
        radEs.setSelected(false);
        radCap.setSelected(false);
        radLa.setSelected(false);
        txtPrice.setText(" ");
    }

    public void bAddActionPerformed(ActionEvent evt) {
        water = 2000;
        milk = 1000;
        beans = 100;
        cups = 10;
        txtWater.setText("" + water);
        txtCups.setText("" + cups);
        txtMilk.setText("" + milk);
        txtBeans.setText("" + beans);
        Water.setForeground(Color.BLACK);
        Beans.setForeground(Color.BLACK);
        Milk.setForeground(Color.BLACK);
        Cups.setForeground(Color.BLACK);
    }

    public void bCheckActionPerformed(ActionEvent evt) {
        txtWater.setText("" + water);
        txtCups.setText("" + cups);
        txtMilk.setText("" + milk);
        txtBeans.setText("" + beans);
    }

    public void bBuyActionPerformed(ActionEvent evt) {
        try {
            Integer.parseInt(txtPrice.getText());
            txtPrice.setText(" ");
            lbPro.setText("---------");
            radEs.setSelected(false);
            radCap.setSelected(false);
            radLa.setSelected(false);
            JOptionPane.showMessageDialog(frame, "Making you a coffee!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please Select Coffee! ", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoffeeMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel Beans;
    private JLabel CoffeeShop;
    private JLabel Cups;
    private JLabel Fill;
    private JLabel Milk;
    private JLabel Water;
    private JButton bAdd;
    private JButton bAddtocart;
    private JButton bBuy;
    private JButton bCheck;
    private JButton bMore;
    private JLabel jLabel1;
    private JLabel lbcapu;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JLabel lbPro;
    private JPanel panelHome;
    private JRadioButton radCap;
    private JRadioButton radEs;
    private JRadioButton radLa;
    private JTextField txtBeans;
    private JTextField txtCups;
    private JTextField txtMilk;
    private JTextField txtPrice;
    private JTextField txtWater;
    private JFrame frame;
    // End of variables declaration
}
