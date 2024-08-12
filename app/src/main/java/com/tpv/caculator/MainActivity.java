package com.tpv.caculator;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;
import java.math.RoundingMode;

import android.graphics.Color;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Button selectedButton = null;
    private Button btn_add, btn_div, btn_sub, btn_multi, btn_eql, btn_dot, btn_clear, btn_negate, btn_pointer;
    private StringBuilder digitalA = new StringBuilder(), digitalB = new StringBuilder();
    private StringBuilder digitalC = new StringBuilder(), digitalD = new StringBuilder();
    private boolean isChar = false, isDot = false, isThird = false;
    private int operate1 = 0 ,operate2=0;
    Button[] btn = new Button[10];
    int[] btnId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) this.findViewById(R.id.result);

        initView();
        btn_add = (Button) this.findViewById(R.id.btn_add);
        btn_sub = (Button) this.findViewById(R.id.btn_sub);
        btn_multi = (Button) this.findViewById(R.id.btn_multi);
        btn_div = (Button) this.findViewById(R.id.btn_div);
        btn_clear = (Button) this.findViewById(R.id.btn_clear);
        btn_eql = (Button) this.findViewById(R.id.btn_eql);
        btn_dot = (Button) this.findViewById(R.id.btn_dot);
        btn_negate = (Button) this.findViewById(R.id.btn_negate);
        btn_pointer = (Button) this.findViewById(R.id.btn_pointer);

        Button[] buttons = {btn_add, btn_sub, btn_multi, btn_div};
        btn_add.setOnClickListener(v ->{
            selectedButton = btn_add;
            btn_add.setEnabled(false);
            operate1 = 1;
                isChar = true;
                if (digitalA.length()!=0 && digitalB.length()!=0) {
                    if (!isThird) {
                        String aStr = digitalA.toString();
                        String bStr = digitalB.toString();
                        BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                        // 使用 BigDecimal 进行精确计算
                        BigDecimal a = new BigDecimal(aStr);
                        BigDecimal b = new BigDecimal(bStr);
                        switch (operate1) {
                            case 1:
                                resultBigDecimal = a.add(b);
                                break;
                            case 2:
                                resultBigDecimal = a.subtract(b);
                                break;
                            case 3:
                                resultBigDecimal = a.multiply(b);
                                break;
                            case 4:
                                resultBigDecimal = a.divide(b);
                                break;
                        }
                        digitalA=new StringBuilder();
                        digitalB=new StringBuilder();
                        digitalA.append(resultBigDecimal.toString());
                        result.setText(digitalA);
                    } else if(isThird){

                        String aStr = digitalA.toString();
                        String bStr = digitalB.toString();
                        String cStr = digitalD.toString();
                        BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                        // 使用 BigDecimal 进行精确计算
                        BigDecimal a = new BigDecimal(aStr);
                        BigDecimal b = new BigDecimal(bStr);
                        BigDecimal c = new BigDecimal(cStr);
                        if(operate2 == 3){
                            switch(operate1){
                                case 1 :
                                    resultBigDecimal = b.multiply(c);
                                    resultBigDecimal = resultBigDecimal.add(a);
                                    break;
                                case 2 :
                                    resultBigDecimal = b.multiply(c);
                                    resultBigDecimal = a.subtract(resultBigDecimal);
                                    break;
                            }
                        }else{
                            switch(operate1){
                                case 1 :
                                    resultBigDecimal = b.divide(c);
                                    resultBigDecimal = resultBigDecimal.add(a);
                                    break;
                                case 2 :
                                    resultBigDecimal = b.divide(c);
                                    resultBigDecimal = a.subtract(resultBigDecimal);
                                    break;
                            }
                        }
                        digitalA=new StringBuilder();
                        digitalB=new StringBuilder();
                        digitalC=new StringBuilder();
                        digitalD=new StringBuilder();
                        isThird = false;
                        isChar = true;
                        digitalA.append(resultBigDecimal.toString());
                        result.setText(digitalA);
                    }
                }
            for (Button btn : buttons) {
                if (btn != selectedButton) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
        });

        btn_sub.setOnClickListener(v -> {
            selectedButton = btn_sub;
                operate1 = 2;
                isChar = true;
            if (digitalA.length()!=0 && digitalB.length()!=0) {
                if (!isThird) {
                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    switch (operate1) {
                        case 1:
                            resultBigDecimal = a.add(b);
                            break;
                        case 2:
                            resultBigDecimal = a.subtract(b);
                            break;
                        case 3:
                            resultBigDecimal = a.multiply(b);
                            break;
                        case 4:
                            resultBigDecimal = a.divide(b);
                            break;
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                } else if(isThird){

                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    String cStr = digitalD.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal c = new BigDecimal(cStr);
                    if(operate2 == 3){
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                break;
                            case 2 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                break;
                        }
                    }else{
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                break;
                            case 2 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                break;
                        }
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalC=new StringBuilder();
                    digitalD=new StringBuilder();
                    isThird = false;
                    isChar = true;
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                }
            }
            for (Button btn : buttons) {
                if (btn != selectedButton) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
                result.setText(digitalA);
        });

        btn_multi.setOnClickListener(v -> {
            selectedButton = btn_multi;
            if (digitalA.length()!=0 && digitalB.length()!=0) {
                if (!isThird) {
                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    switch (operate1) {
                        case 1:
                        case 2:
                            operate2 = 3;
                            isThird = true;
                            isChar = false;
                            break;
                        case 3:
                            resultBigDecimal = a.multiply(b);
                            digitalA=new StringBuilder();
                            digitalB=new StringBuilder();
                            digitalA.append(resultBigDecimal.toString());
                            result.setText(digitalA);
                            operate1 = 3;
                            isChar = true;
                            break;
                        case 4:
                            resultBigDecimal = a.divide(b);
                            digitalA=new StringBuilder();
                            digitalB=new StringBuilder();
                            digitalA.append(resultBigDecimal.toString());
                            result.setText(digitalA);
                            operate1 = 3;
                            isChar = true;
                            break;
                    }
                } else if(isThird){

                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    String cStr = digitalD.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal c = new BigDecimal(cStr);
                    if(operate2 == 3){
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                operate1 = 3;
                                isChar = true;
                                isThird = false;
                                break;
                            case 2 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                operate1 = 3;
                                isChar = true;
                                isThird = false;
                                break;
                        }
                    }else{
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                operate1 = 3;
                                isChar = true;
                                isThird = false;
                                break;
                            case 2 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                operate1 = 3;
                                isChar = true;
                                isThird = false;
                                break;
                        }
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalC=new StringBuilder();
                    digitalD=new StringBuilder();
                    isThird = false;
                    isChar = true;
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                }
            } else {
                operate1 = 3;
                isChar = true;
            }
            for (Button btn : buttons) {
                if (btn != selectedButton) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
        });

        btn_div.setOnClickListener(v -> {
            selectedButton = btn_div;
            if (digitalA.length()!=0 && digitalB.length()!=0) {
                if (!isThird) {
                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    switch (operate1) {
                        case 1:
                        case 2:
                            operate2 = 4;
                            isThird = true;
                            isChar = false;
                            break;
                        case 3:
                            resultBigDecimal = a.multiply(b);
                            digitalA=new StringBuilder();
                            digitalB=new StringBuilder();
                            digitalA.append(resultBigDecimal.toString());
                            result.setText(digitalA);
                            operate1 = 4;
                            isChar = true;
                            break;
                        case 4:
                            resultBigDecimal = a.divide(b);
                            digitalA=new StringBuilder();
                            digitalB=new StringBuilder();
                            digitalA.append(resultBigDecimal.toString());
                            result.setText(digitalA);
                            operate1 = 4;
                            isChar = true;
                            break;
                    }
                } else if(isThird){

                    String aStr = digitalA.toString();
                    String bStr = digitalB.toString();
                    String cStr = digitalD.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal c = new BigDecimal(cStr);
                    if(operate2 == 3){
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                operate1 = 4;
                                isChar = true;
                                isThird = false;
                                break;
                            case 2 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                operate1 = 4;
                                isChar = true;
                                isThird = false;
                                break;
                        }
                    }else{
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                operate1 = 4;
                                isChar = true;
                                isThird = false;
                                break;
                            case 2 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                operate1 = 4;
                                isChar = true;
                                isThird = false;
                                break;
                        }
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalC=new StringBuilder();
                    digitalD=new StringBuilder();
                    isThird = false;
                    isChar = true;
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                }
            } else {
                operate1 = 4;
                isChar = true;
            }
            for (Button btn : buttons) {
                if (btn != selectedButton) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
            result.setText(digitalA);
        });


        btn_clear.setOnClickListener(v ->{
                digitalA.delete(0,digitalA.length());
                digitalB.delete(0,digitalB.length());
                digitalC.delete(0,digitalC.length());
            digitalD.delete(0,digitalC.length());
                result.setText("0");
                for (Button btn : buttons) {
                    btn.setEnabled(true); // 直接禁用所有按钮
                }
                isChar = false;
            isDot = false;
            isThird = false;
        });
        btn_dot.setOnClickListener(new MyClick());
        btn_negate.setOnClickListener(v ->{
            if(isChar){
                float b = Float.parseFloat(digitalB.toString());
                if(b != 0){
                    float negatedValue = -b;
                    if ((int) b == b) {
                        digitalB = new StringBuilder(String.valueOf((int) negatedValue));
                    } else {
                        digitalB = new StringBuilder(String.valueOf(negatedValue));
                    }

                }
                result.setText(digitalB);
            } else if(isThird){
                float d = Float.parseFloat(digitalD.toString());
                if(d != 0){
                    float negatedValue = -d;
                    if ((int) d == d) {
                        digitalD = new StringBuilder(String.valueOf((int) negatedValue));
                    } else {
                        digitalD = new StringBuilder(String.valueOf(negatedValue));
                    }

                }
                result.setText(digitalD);
            } else{
                float a = Float.parseFloat(digitalA.toString());
                if(a != 0){
                    float negatedValue = -a;
                    if ((int) a == a) {
                        digitalA = new StringBuilder(String.valueOf((int) negatedValue));
                    } else {
                        digitalA = new StringBuilder(String.valueOf(negatedValue));
                    }

                }
                result.setText(digitalA);
            }

        });
        btn_pointer.setOnClickListener(v -> {
            try {
                if(isChar){
                    String aStr = digitalB.toString();
                    String bStr = "100";

                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal resultBigDecimal = a.divide(b);

                    digitalB=new StringBuilder();
                    digitalB.append(resultBigDecimal.toString());
                    result.setText(digitalB);
                } else if(isThird){
                    String aStr = digitalD.toString();
                    String bStr = "100";

                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal resultBigDecimal = a.divide(b);

                    digitalD=new StringBuilder();
                    digitalD.append(resultBigDecimal.toString());
                    result.setText(digitalD);
                } else {
                    String aStr = digitalA.toString();
                    String bStr = "100";

                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal resultBigDecimal = a.divide(b);

                    digitalA=new StringBuilder();
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                }


            } catch (ArithmeticException e) {
                // 处理除数为0或其他算术异常
                result.setText("Error: Division by zero or arithmetic error.");
            }
        });
        btn_eql.setOnClickListener(v -> {
            selectedButton = btn_eql;
            for (Button btn : buttons) {
                btn.setEnabled(true);
            }
            digitalC = digitalB;
            if (digitalA.length()!=0 && digitalB.length()!=0) {
                if (!isThird) {
                    String aStr = digitalA.toString();
                    String bStr = digitalC.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    switch (operate1) {
                        case 1:
                            resultBigDecimal = a.add(b);
                            break;
                        case 2:
                            resultBigDecimal = a.subtract(b);
                            break;
                        case 3:
                            resultBigDecimal = a.multiply(b);
                            break;
                        case 4:
                            resultBigDecimal = a.divide(b);
                            break;
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                } else if(isThird){

                    String aStr = digitalA.toString();
                    String bStr = digitalC.toString();
                    String cStr = digitalD.toString();
                    BigDecimal resultBigDecimal = null; // 在 switch 外声明，以便在 switch 后使用
                    // 使用 BigDecimal 进行精确计算
                    BigDecimal a = new BigDecimal(aStr);
                    BigDecimal b = new BigDecimal(bStr);
                    BigDecimal c = new BigDecimal(cStr);
                    if(operate2 == 3){
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                break;
                            case 2 :
                                resultBigDecimal = b.multiply(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                break;
                        }
                    }else{
                        switch(operate1){
                            case 1 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = resultBigDecimal.add(a);
                                break;
                            case 2 :
                                resultBigDecimal = b.divide(c);
                                resultBigDecimal = a.subtract(resultBigDecimal);
                                break;
                        }
                    }
                    digitalA=new StringBuilder();
                    digitalB=new StringBuilder();
                    digitalC=new StringBuilder();
                    digitalD=new StringBuilder();
                    isThird = false;
                    isChar = true;
                    digitalA.append(resultBigDecimal.toString());
                    result.setText(digitalA);
                }
            }
        });

        MyClick myClick = new MyClick();
        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(myClick);
        }
    }

    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button[] buttons = {btn_add, btn_sub, btn_multi, btn_div};
            for (Button btn : buttons) {
                btn.setEnabled(true); // 直接禁用所有按钮
            }
            switch (view.getId()) {
                case R.id.btn_dot:
                    if (isChar) {
                        if (!isDot) {
                            if (digitalB.length() > 0) {
                                digitalB.append(".");
                                isDot = true;
                                break;
                            } else {
                                digitalB.append("0");
                                digitalB.append(".");
                                isDot = true;
                                break;
                            }
                        }
                        break;
                    } else if(isThird){
                        if (!isDot) {
                            if (digitalD.length() > 0) {
                                digitalD.append(".");
                                isDot = true;
                                break;
                            } else {
                                digitalD.append("0");
                                digitalD.append(".");
                                isDot = true;
                                break;
                            }
                        }
                        break;
                    } else {
                        if (!isDot) {
                            if (digitalA.length() > 0) {
                                digitalA.append(".");
                                isDot = true;
                                break;
                            } else {
                                digitalA.append("0");
                                digitalA.append(".");
                                isDot = true;
                                break;
                            }
                        }
                        break;
                    }
                case R.id.btn1:
                    if (isChar) {
                        digitalB.append('1');
                    }else if(isThird){
                        digitalD.append("1");
                    } else {
                        digitalA.append("1");

                    }
                    break;
                case R.id.btn2:
                    if (isChar) {
                        digitalB.append('2');
                    } else if(isThird){
                        digitalD.append("2");
                    } else {
                        digitalA.append("2");
                    }
                    break;
                case R.id.btn3:
                    if (isChar) {
                        digitalB.append('3');
                    }else if(isThird){
                        digitalD.append("3");
                    } else {
                        digitalA.append("3");
                    }
                    break;
                case R.id.btn4:
                    if (isChar) {
                        digitalB.append('4');
                    }else if(isThird){
                        digitalD.append("4");
                    } else {
                        digitalA.append("4");
                    }
                    break;
                case R.id.btn5:
                    if (isChar) {
                        digitalB.append('5');
                    }else if(isThird){
                        digitalD.append("5");
                    } else {
                        digitalA.append("5");
                    }
                    break;
                case R.id.btn6:
                    if (isChar) {
                        digitalB.append('6');
                    } else if(isThird){
                        digitalD.append("6");
                    } else {
                        digitalA.append("6");
                    }
                    break;
                case R.id.btn7:
                    if (isChar) {
                        digitalB.append('7');
                    }else if(isThird){
                        digitalD.append("7");
                    } else {
                        digitalA.append("7");
                    }
                    break;
                case R.id.btn8:
                    if (isChar) {
                        digitalB.append('8');
                    }else if(isThird){
                        digitalD.append("8");
                    } else {
                        digitalA.append("8");
                    }
                    break;
                case R.id.btn9:
                    if (isChar) {
                        digitalB.append('9');
                    }else if(isThird){
                        digitalD.append("9");
                    } else {
                        digitalA.append("9");
                    }
                    break;
                case R.id.btn0:
                    if (isChar) {
                        digitalB.append('0');
                    } else if(isThird){
                        digitalD.append("0");
                    } else {
                        digitalA.append("0");
                    }
                    break;


            }
            if (isChar) {
                result.setText(digitalB.toString());
            } else if(isThird){
                result.setText(digitalD.toString());
            }else {
                result.setText(digitalA.toString());

            }
            selectedButton = btn_dot;
        }
    }
    void initView() {
        for (int i = 0; i < btn.length; i++) {
            btn[i] = (Button) this.findViewById(btnId[i]);
        }
    }
}

