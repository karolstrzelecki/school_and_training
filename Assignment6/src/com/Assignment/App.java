// Karol Strzelecki id: 19101653

package com.Assignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App {

    private final Main test;
    JFrame frame;


    // Sorry I read that every event handler needs to print out what it is doing just after i made my programm (i think)
    // fully functionally so you can check the status of every button after clicking status

    // I didn't know if i have to make light control for one or more places
    // So i made it for 4 places, but unfortunately i made a lof of lines of code similar to other
    // Important things are from line: 1 - 197 and 500 - to the end of program
    //


    //===== Variables needed to operate the program
    // Kitchen

    boolean b1a = false;
    boolean b2a = false;
    JLabel lighta = new JLabel();
    JSlider lightLevela;
    JButton button1a;
    JButton button2a;

    // Bathroom

    boolean b1b = false;
    boolean b2b = false;
    JLabel lightb = new JLabel();
    JSlider lightLevelb;
    JButton button1b;
    JButton button2b;

    // Living room

    boolean b1c = false;
    boolean b2c = false;
    JLabel lightc = new JLabel();
    JSlider lightLevelc;
    JButton button1c;
    JButton button2c;


    //

    boolean b1d = false;
    boolean b2d = false;
    JLabel lightd = new JLabel();
    JSlider lightLeveld;
    JButton button1d;
    JButton button2d;


    // Control Panel buttons

    JTextArea info;
    JButton button3;


    // Array of colors of light
    Color arr[] = {new Color(255, 211, 25),
            new Color(255, 255, 0),
            new Color(255, 255, 125),
            new Color(255, 255, 240)};


    public App(Main incomingReference) {

        // I'm sending variable to outer class
        this.test = incomingReference;


        // EventListeners of Kitchen
        button1a = new JButton("OFF");
        button1a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b1a == false) {
                    button1a.setText("ON");
                    b1a = true;


                    lighta.setBackground(arr[test.getVara() - 1]);

                } else {
                    button1a.setText("OFF");
                    b1a = false;
                    lighta.setBackground(new Color(0, 0, 0));

                }
            }
        });


        // I didn't know what's about automatic mode, so i made that light will shut down after 5 seconds
        // without changing intensity, I used there very simple Timer class to turn off

        button2a = new JButton("Manual");
        button2a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b2a == false && b1a == true) {
                    button2a.setText("Auto");
                    b2a = true;
                    Timer t = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            button1a.setText("OFF");
                            b1a = false;
                            lighta.setBackground(new Color(0, 0, 0));
                            button2a.setText("Manual");
                            b2a = false;


                        }
                    });
                    t.setRepeats(false);
                    t.start();


                } else {
                    button2a.setText("Manual");
                    b2a = false;
                }
            }
        });

        // I made 4 level (from 1 to 4) horizontal JSlider which should show Paint ticks and PaintLabels
        // You can choose level of light when it is turned off, when you click the button to turn on the light
        // with previously chosen level it will turn on this level
        // to do that i created some getters and setters in Main Class (outer one), because i had problem with operating
        // on variable chosen on slider
        lightLevela = new JSlider(JSlider.HORIZONTAL,
                1, 4, 1);
        lightLevela.setPaintTicks(true);
        lightLevela.setPaintLabels(true);

        lightLevela.addChangeListener(new ChangeListener() {
                                          @Override
                                          public void stateChanged(ChangeEvent e) {
                                              JSlider source;
                                              source = (JSlider) e.getSource();
                                              test.setVara(source.getValue());


                                              if (b1a == true) {
                                                  int i = test.getVara();

                                                  lighta.setBackground(arr[i - 1]);
                                              }
                                          }
                                      }

        );

        JLabel titlea = new JLabel("Kitchen", SwingConstants.CENTER);

        lighta.setBackground(new Color(0, 0, 0));
        lighta.setPreferredSize(new Dimension(50, 50));
        lighta.setOpaque(true);

        // This is JTextArea used to show status of light in individual room
        // i set it uneditable because it should show information only

        JTextArea infoa = new JTextArea();
        infoa.setEditable(false);


        // I put every component in separate panels for each room
        // every panel contains 6 rows and 1 column GridLayout (it looks quite smooth for me)

        // JPanel of Kitchen

        JPanel kitchenPanel = new JPanel();
        kitchenPanel.setLayout(new GridLayout(6, 1));

        // Adding components to panel

        kitchenPanel.add(titlea);
        kitchenPanel.add(lighta);
        kitchenPanel.add(button1a);
        kitchenPanel.add(lightLevela);
        kitchenPanel.add(button2a);
        kitchenPanel.add(infoa);



        // In every room are same Action listeners with different variables declarated on the top of this class


// ==== Bathrooom ====


        // EventListeners of Kitchen
        button1b = new JButton("OFF");
        button1b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b1b == false) {
                    button1b.setText("ON");
                    b1b = true;


                    lightb.setBackground(arr[test.getVarb() - 1]);

                } else {
                    button1b.setText("OFF");
                    b1b = false;
                    lightb.setBackground(new Color(0, 0, 0));

                }
            }
        });


        button2b = new JButton("Manual");
        button2b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b2b == false && b1b == true) {
                    button2b.setText("Auto");
                    b2b = true;
                    Timer t = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            button1b.setText("OFF");
                            b1b = false;
                            lightb.setBackground(new Color(0, 0, 0));
                            button2b.setText("Manual");
                            b2b = false;


                        }
                    });
                    t.setRepeats(false);
                    t.start();


                } else {
                    button2b.setText("Manual");
                    b2b = false;
                }
            }
        });


        lightLevelb = new JSlider(JSlider.HORIZONTAL,
                1, 4, 1);
        lightLevelb.setPaintTicks(true);
        lightLevelb.setPaintLabels(true);

        lightLevelb.addChangeListener(new ChangeListener() {
                                          @Override
                                          public void stateChanged(ChangeEvent e) {
                                              JSlider source;
                                              source = (JSlider) e.getSource();
                                              test.setVarb(source.getValue());


                                              if (b1b == true) {
                                                  int i = test.getVarb();

                                                  lightb.setBackground(arr[i - 1]);
                                              }
                                          }
                                      }

        );


        lightb.setBackground(new Color(0, 0, 0));
        lightb.setPreferredSize(new Dimension(50, 50));
        lightb.setOpaque(true);


        // JPanel of Bathroom
        JLabel titleb = new JLabel("Bathroom", SwingConstants.CENTER);


        JPanel bathroomPanel = new JPanel();
        bathroomPanel.setLayout(new GridLayout(6, 1));

        JTextArea infob = new JTextArea();
        infob.setEditable(false);

        bathroomPanel.add(titleb);
        bathroomPanel.add(lightb);
        bathroomPanel.add(button1b);
        bathroomPanel.add(lightLevelb);
        bathroomPanel.add(button2b);
        bathroomPanel.add(infob);


        // ===== Livingroom


        // EventListeners of LivingRoom
        button1c = new JButton("OFF");
        button1c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b1c == false) {
                    button1c.setText("ON");
                    b1c = true;


                    lightc.setBackground(arr[test.getVarc() - 1]);

                } else {
                    button1c.setText("OFF");
                    b1c = false;
                    lightc.setBackground(new Color(0, 0, 0));

                }
            }
        });


        button2c = new JButton("Manual");
        button2c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b2c == false && b1c == true) {
                    button2c.setText("Auto");
                    b2c = true;
                    Timer t = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            button1c.setText("OFF");
                            b1c = false;
                            lightc.setBackground(new Color(0, 0, 0));
                            button2c.setText("Manual");
                            b2c = false;


                        }
                    });
                    t.setRepeats(false);
                    t.start();


                } else {
                    button2c.setText("Manual");
                    b2c = false;
                }
            }
        });


        lightLevelc = new JSlider(JSlider.HORIZONTAL,
                1, 4, 1);
        lightLevelc.setPaintTicks(true);
        lightLevelc.setPaintLabels(true);

        lightLevelc.addChangeListener(new ChangeListener() {
                                          @Override
                                          public void stateChanged(ChangeEvent e) {
                                              JSlider source;
                                              source = (JSlider) e.getSource();
                                              test.setVarc(source.getValue());


                                              if (b1c == true) {
                                                  int i = test.getVarc();

                                                  lightc.setBackground(arr[i - 1]);
                                              }
                                          }
                                      }

        );
        JLabel titlec = new JLabel("Living room", SwingConstants.CENTER);


        lightc.setBackground(new Color(0, 0, 0));
        lightc.setPreferredSize(new Dimension(50, 50));
        lightc.setOpaque(true);

        JTextArea infoc = new JTextArea();
        infoc.setEditable(false);


        // JPanel of living room

        JPanel livingRoomPanel = new JPanel();
        livingRoomPanel.setLayout(new GridLayout(6, 1));

        livingRoomPanel.add(titlec);
        livingRoomPanel.add(lightc);
        livingRoomPanel.add(button1c);
        livingRoomPanel.add(lightLevelc);
        livingRoomPanel.add(button2c);
        livingRoomPanel.add(infoc);


        // ==== Bedroom ====


        // EventListeners
        button1d = new JButton("OFF");
        button1d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b1d == false) {
                    button1d.setText("ON");
                    b1d = true;


                    lightd.setBackground(arr[test.getVard() - 1]);

                } else {
                    button1d.setText("OFF");
                    b1d = false;
                    lightd.setBackground(new Color(0, 0, 0));

                }
            }
        });


        button2d = new JButton("Manual");
        button2d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b2d == false && b1d == true) {
                    button2d.setText("Auto");
                    b2d = true;
                    Timer t = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            button1d.setText("OFF");
                            b1d = false;
                            lightd.setBackground(new Color(0, 0, 0));
                            button2d.setText("Manual");
                            b2d = false;


                        }
                    });
                    t.setRepeats(false);
                    t.start();


                } else {
                    button2d.setText("Manual");
                    b2d = false;
                }
            }
        });


        lightLeveld = new JSlider(JSlider.HORIZONTAL,
                1, 4, 1);
        lightLeveld.setPaintTicks(true);
        lightLeveld.setPaintLabels(true);

        lightLeveld.addChangeListener(new ChangeListener() {
                                          @Override
                                          public void stateChanged(ChangeEvent e) {
                                              JSlider source;
                                              source = (JSlider) e.getSource();
                                              test.setVard(source.getValue());


                                              if (b1d == true) {
                                                  int i = test.getVard();

                                                  lightd.setBackground(arr[i - 1]);
                                              }
                                          }
                                      }

        );
        JLabel titled = new JLabel("Bedroom", SwingConstants.CENTER);


        lightd.setBackground(new Color(0, 0, 0));
        lightd.setPreferredSize(new Dimension(50, 50));
        lightd.setOpaque(true);


        // JPanel of Bedroom

        JPanel bedroomPanel = new JPanel();
        bedroomPanel.setLayout(new GridLayout(6, 1));

        JTextArea infod = new JTextArea();
        infod.setEditable(false);

        bedroomPanel.add(titled);
        bedroomPanel.add(lightd);
        bedroomPanel.add(button1d);
        bedroomPanel.add(lightLeveld);
        bedroomPanel.add(button2d);
        bedroomPanel.add(infod);


        // Rooms control panel
        // I created JPanel with GridLayout Manager which contains 4 colums and 1 row
        // Then I added panels created previously for each room in light control

        JPanel cPanel = new JPanel();
        cPanel.setLayout(new GridLayout(1, 4));

        cPanel.add(kitchenPanel);
        cPanel.add(bathroomPanel);
        cPanel.add(livingRoomPanel);
        cPanel.add(bedroomPanel);


        // Status Button, after click on that button there will be status displayed on text fields of every room

        button3 = new JButton("Status");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                infoa.setText("Light is ON: " + b1a
                        + "\nAutomatic Mode: " + b2a
                        + "\nLight level: " + test.getVara()
                );
                infob.setText("Light is ON: " + b1b
                        + "\nAutomatic Mode: " + b2b
                        + "\nLight level: " + test.getVarb()
                );
                infoc.setText("Light is ON: " + b1c
                        + "\nAutomatic Mode: " + b2c
                        + "\nLight level: " + test.getVarc()
                );
                infod.setText("Light is ON: " + b1d
                        + "\nAutomatic Mode: " + b2d
                        + "\nLight level: " + test.getVard()
                );


            }
        });



        // Title JLabel

        JLabel text = new JLabel("Super Light Control 3000", SwingConstants.CENTER);


        // ==== Settings of the frame

        // Fame has border Layout

        frame = new JFrame("Light Control");
        frame.setLayout(new BorderLayout());
        frame.add(text, BorderLayout.NORTH);
        frame.add(cPanel, BorderLayout.CENTER);
        frame.add(button3, BorderLayout.SOUTH);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 250); // Best Location of window for 13 inch Macbook Retina
        frame.setVisible(true);


        frame.pack();


    }


}