package com.example.multichose;

public class Question {
    public static String[] mQuestions  = new String[]{ //Mảng lưu trữ danh sách câu hỏi
            "What animal in image is it?",
            "What is it ?",
            "1 + 1 = ?",
            "What day is national vietnam day?",
            "What animal is it ?",
            "What animal is it ?"


    };


    public static String mChoices [][] = {  //Mảng lưu trữ danh sách các câu trả lời của từng câu hỏi
            {"deer", "tiger", "rabbit","bee"},
            {"monkey", "zebra", "bee","tiger"},
            {"4", "3", "2","1"},
            {"2/9", "3/9", "4/9","10/9"},
            {"zebra","tiger","bee","lion"},
            {"tiger","bee","rabbit","deer"}
    };
    public static int[] images = new int[]{  //Mảng lưu trữ ảnh của từng câu hỏi
            R.drawable.deel,
            R.drawable.bee,
            R.drawable.download,
            R.drawable.bando,
            R.drawable.lion,
            R.drawable.rabbit,
    };



    public static String mCorrectAnswers[] = { //Danh sách câu trả lòi đúng của từng câu hỏi
            "deer",
            "bee",
            "2",
            "2/9",
            "lion",
            "rabbit",
    };




    public String getQuestion(int a) { //Lấy ra câu hỏi theo thứ tự mảng
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) { //Lấy ra câu trả lời cho lựa chọn thứ 1
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) { //Lấy ra câu trả lời cho lựa chọnthứ 2
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) { //Lấy ra câu trả lời cho lựa chọnthứ 3
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4(int a) { //Lấy ra câu trả lời cho lựa chọn thứ 4
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) { //Lấy ra câu trả lời đúng
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
