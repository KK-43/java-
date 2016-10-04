import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {
	JTextField t1,t2,jtf;
	int n1,d1,n2,d2,a1,a2;
        Fraction f1,f2;
	static Fraction m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch,toogle;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp,
			fac, plus, min, div, log, rec, mul, eq, addSub, nd, mr, mc, mp,
			mm, sqrt, sin, cos, tan;
	Container cont;
	JPanel textPanel, buttonpanel;
        Color lal=new Color(254,50,26);
        Color neela=new Color(92,202,218);
        Color hara=new Color(92,175,59);
        Color peela=new Color(250,250,90);
        Color pinky=new Color(254,143,220);

	ScientificCalculator() {
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
                textpanel.setLayout(new GridLayout(0,1));
		t1 = new JTextField(25);
                t2=new JTextField(25);
                t1.setBackground(neela);
                t2.setBackground(lal);
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
                t2.setHorizontalAlignment(SwingConstants.RIGHT);
                f1=new Fraction();
                f2=new Fraction();
                m1=new Fraction(0,1);
                m2=new Fraction(0,1);

		t1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent keyevent) {
				char c = keyevent.getKeyChar();
				if (c >= '0' && c <= '9') {
				} else {
					keyevent.consume();
				}
			}
		});

                t2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent keyevent) {
				char c = keyevent.getKeyChar();
				if (c >= '0' && c <= '9') {
				} else {
					keyevent.consume();
				}
			}
		});

                toogle='N';

                textpanel.add(new JLabel("NUMERATOR"));
		textpanel.add(t1);
                textpanel.add(new JLabel("DENOMINATOR"));
                textpanel.add(t2);

                JPanel bottompanel=new JPanel();
                jtf=new JTextField(20);
                jtf.setEditable(false); 
                jtf.setBackground(peela);
                bottompanel.add(jtf);

		buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(8, 4, 2, 2));
		boolean t = true;

		mr = new JButton("MR");
		buttonpanel.add(mr);
                mr.addActionListener(this);
                mr.setBackground(hara);

		mc = new JButton("MC");
		buttonpanel.add(mc);
		mc.addActionListener(this);
                mc.setBackground(hara);

		mp = new JButton("M+");
		buttonpanel.add(mp);
		mp.addActionListener(this);
                mp.setBackground(hara);

		mm = new JButton("M-");
		buttonpanel.add(mm);
		mm.addActionListener(this);
                mm.setBackground(hara);

		b1 = new JButton("1");
		buttonpanel.add(b1);
		b1.addActionListener(this);
                b1.setBackground(pinky);

		b2 = new JButton("2");
		buttonpanel.add(b2);
                b2.addActionListener(this);
                b2.setBackground(pinky);

		b3 = new JButton("3");
		buttonpanel.add(b3);
		b3.addActionListener(this);
                b3.setBackground(pinky);

		b4 = new JButton("4");
		buttonpanel.add(b4);
		b4.addActionListener(this);
                b4.setBackground(pinky);

		b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(this);
                b5.setBackground(pinky);

		b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(this);
                b6.setBackground(pinky);


		b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(this);
                b7.setBackground(pinky);

		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(this);
                b8.setBackground(pinky);

		b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(this);
                b9.setBackground(pinky);

		zero = new JButton("0");
		buttonpanel.add(zero);
		zero.addActionListener(this);
                zero.setBackground(pinky);

		plus = new JButton("+");
		buttonpanel.add(plus);
		plus.addActionListener(this);
                plus.setBackground(hara);

		min = new JButton("-");
		buttonpanel.add(min);
		min.addActionListener(this);
                min.setBackground(hara);

		mul = new JButton("*");
		buttonpanel.add(mul);
		mul.addActionListener(this);
                mul.setBackground(hara);

		div = new JButton("/");
		div.addActionListener(this);
		buttonpanel.add(div);
                div.setBackground(hara);

		addSub = new JButton("+/-");
		buttonpanel.add(addSub);
		addSub.addActionListener(this);
                addSub.setBackground(hara);

		nd = new JButton("N/D");
		buttonpanel.add(nd);
		nd.addActionListener(this);
                nd.setBackground(neela);

		eq = new JButton("=");
		buttonpanel.add(eq);
		eq.addActionListener(this);
                eq.setBackground(Color.orange);

		rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(this);
                rec.setBackground(hara);

		sqrt = new JButton("Sqrt");
		buttonpanel.add(sqrt);
		sqrt.addActionListener(this);
                sqrt.setBackground(hara);

		log = new JButton("log");
		buttonpanel.add(log);
		log.addActionListener(this);
                log.setBackground(hara);

		sin = new JButton("SIN");
		buttonpanel.add(sin);
		sin.addActionListener(this);
                sin.setBackground(hara);

		cos = new JButton("COS");
		buttonpanel.add(cos);
		cos.addActionListener(this);
                cos.setBackground(hara);

		tan = new JButton("TAN");
		buttonpanel.add(tan);
		tan.addActionListener(this);
                tan.setBackground(hara);

		pow2 = new JButton("x^2");
                buttonpanel.add(pow2);
		pow2.addActionListener(this);
                pow2.setBackground(hara);

		pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
                pow3.addActionListener(this);
                pow3.setBackground(hara);

		exp = new JButton("Exp");
		exp.addActionListener(this);
		buttonpanel.add(exp);
                exp.setBackground(hara);

		fac = new JButton("Val");
		fac.addActionListener(this);
		buttonpanel.add(fac);
                fac.setBackground(hara);

		clr = new JButton("AC");
		buttonpanel.add(clr);
		clr.addActionListener(this);
                clr.setBackground(Color.cyan);

		cont.add("Center", buttonpanel);
		cont.add("North", textpanel);
                cont.add("South",bottompanel);                

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		if (s.equals("1")) {   //for 1
                    if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "1");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "1");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "1");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "1");
				z = 0;
			}
                   }
		}

		if (s.equals("2")) {  //for 2
		   if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "2");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "2");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "2");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "2");
				z = 0;
			}
                   }	
		}

		if (s.equals("3")) {  //for 3
                    if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "3");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "3");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "3");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "3");
				z = 0;
			}
                   }			
		}

		if (s.equals("4")) {  //for 4
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "4");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "4");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "4");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "4");
				z = 0;
			}
                   }
		}

		if (s.equals("5")) {  //for 5
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "5");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "5");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "5");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "5");
				z = 0;
			}
                   }
		}

		if (s.equals("6")) {  //for 6
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "6");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "6");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "6");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "6");
				z = 0;
			}
                   }
		}

		if (s.equals("7")) {  //for 7
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "7");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "7");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "7");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "7");
				z = 0;
			}
                   }
		}

		if (s.equals("8")) {  //for 8
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "8");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "8");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "8");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "8");
				z = 0;
			}
                   }
		}

		if (s.equals("9")) {  //for 9
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "9");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "9");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "9");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "9");
				z = 0;
			}
                   }
		}

		if (s.equals("0")) {  //for 0
			if(toogle=='N'){
			if (z == 0) {
                                
				t1.setText(t1.getText() + "0");
			} else {
				t1.setText("");
				t1.setText(t1.getText() + "0");
				z = 0;
			}
                   }
                   else if(toogle=='D'){
                       if (z == 0) {
                                
				t2.setText(t2.getText() + "0");
			} else {
				t2.setText("");
				t2.setText(t2.getText() + "0");
				z = 0;
			}
                   }		
                }

		if (s.equals("AC")) {  //to clear
			t1.setText("");
			x = 0;
			y = 0;
			z = 0;
                        t2.setText(""); 
                        jtf.setText("");
		}

		if (s.equals("log")) {  //find log
			if (t1.getText().equals("") || t2.getText().equals("")) {//empty textfield
				t1.setText("");
                                t2.setText(""); 
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
				jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("1/x")) {  //invert
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText(""); 
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
				t1.setText("");
                                t2.setText("");
				t1.setText(t1.getText() + a2);
                                t2.setText(t2.getText() + a1);
			}
		}

		if (s.equals("Exp")) { //find exponent
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                ans=Math.exp(ans);
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("x^2")) {  //square
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                f1=f1.multiply(f1);
                                f1.reduce();
                                t1.setText("");
                                t2.setText("");
				t1.setText(t1.getText() + f1.getNumerator());
                                t2.setText(t2.getText() + f1.getDenominator());
			}
		}

		if (s.equals("x^3")) {  //cube
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
			        a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                f1=f1.multiply(f1.multiply(f1));
                                f1.reduce();
                                t1.setText("");
                                t2.setText("");
				t1.setText(t1.getText() + f1.getNumerator());
                                t2.setText(t2.getText() + f1.getDenominator());
			}
		}

		if (s.equals("+/-")) {  //sign change
			if (x == 0) {  //no -ve sign
				t1.setText("-" + t1.getText());
				x = 1;
			} else {  //for -ve sign
                                String st=t1.getText();
				t1.setText(st.substring(1));
                                x=0;
                                //-ve sign removed
			}
		}

		if (s.equals("N/D")) {  //to change from numerator to denominator
			if (toogle=='N') {
				toogle='D';
                                nd.setBackground(lal);
				//y = 1;
			} else if(toogle=='D'){
				toogle='N';
                                nd.setBackground(neela);
			}
		}
		if (s.equals("+")) {  //addition
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
				f1.setNumerator(0);
                                f1.setDenominator(1);
				ch = '+';
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                t1.setText("");
                                t2.setText("");
				ch = '+';
				y = 0;
				x = 0;
			}
			//tfield.requestFocus();
		}

		if (s.equals("-")) {  //subtraction
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
				f1.setNumerator(0);
                                f1.setDenominator(1);
				ch = '-';
			} else {
				x = 0;
				y = 0;
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                t1.setText("");
                                t2.setText("");
				ch = '-';
			}
			//tfield.requestFocus();
		}
		if (s.equals("/")) {  //division
		       if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
				f1.setNumerator(1);
                                f1.setDenominator(1);
				ch = '/';
			} else {
				x = 0;
				y = 0;
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                t1.setText("");
                                t2.setText("");
				ch = '/';
			}	
		}

		if (s.equals("*")) {  //multiplication
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
				f1.setNumerator(0);
                                f1.setDenominator(1);
				ch = '*';
			} else {
				x = 0;
				y = 0;
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                t1.setText("");
                                t2.setText("");
				ch = '*';
			}		
                }

		if (s.equals("MC")) {  //clears memory
			m1.setNumerator(0);
                        m1.setNumerator(1);
			t1.setText("");
                        t2.setText("");
		}
		if (s.equals("MR")) {  //retrieves memory
			t1.setText("");
                        t2.setText("");
			t1.setText(t1.getText() + m1.getNumerator());
                        t2.setText(t2.getText() + m1.getDenominator());
		}
		if (s.equals("M+")) {  //add to memory
			if (k == 1) {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                m1.setNumerator(a1);
                                m1.setDenominator(a2);
				k++;
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                m2.setNumerator(a1);
                                m2.setDenominator(a2);
                                m1=m1.add(m2);
			}
		}
		if (s.equals("M-")) {  //subtract from memory
			if (k == 1) {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                m1.setNumerator(a1);
                                m1.setDenominator(a2);
				k++;
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                m2.setNumerator(a1);
                                m2.setDenominator(a2);
                                m1=m1.subtract(m2);
			}
		}

		if (s.equals("Sqrt")) {  //find sqrt of the float value
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                ans=Math.sqrt(ans);
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("SIN")) {  //sine
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                ans=Math.sin(ans);
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("COS")) {  //cos
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                ans=Math.cos(ans);
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("TAN")) {  //tan
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                ans=Math.tan(ans);
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
			}
		}

		if (s.equals("=")) {  //ans
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
			}  else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f2.setNumerator(a1);
                                f2.setDenominator(a2);
				switch (ch) {
				case '+':
					f1=f1.add(f2);
					break;
				case '-':
					f1=f1.subtract(f2);
					break;
				case '/':
					f1=f1.multiply(f2);
					break;
				case '*':
					f1=f1.divide(f2);
					break;
				}
				t1.setText("");
                                t2.setText("");
				t1.setText(t1.getText() + f1.getNumerator());
                                t2.setText(t2.getText() + f1.getDenominator());
				z = 1;
			}
		}

		if (s.equals("Val")) {  //float value
			if (t1.getText().equals("") || t2.getText().equals("")) {
				t1.setText("");
                                t2.setText("");
                                jtf.setText("");
			} else {
				a1 = Integer.parseInt(t1.getText());
                                a2 = Integer.parseInt(t2.getText());
                                f1.setNumerator(a1);
                                f1.setDenominator(a2);
                                double ans=f1.toDouble();
                                jtf.setText("");
				jtf.setText(jtf.getText() + ans);
                                
			}
		}
		//tfield.requestFocus();
	}

	

	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		ScientificCalculator f = new ScientificCalculator();
		f.setTitle("ScientificCalculator");
		f.pack();
		f.setVisible(true);
	}
}

