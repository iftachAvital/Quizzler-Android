package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private int mIndex;
    private int mScore;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((v.getId() == R.id.true_button && mQuestionBank[mIndex].isAnswer()) ||
                        (v.getId() == R.id.false_button && !mQuestionBank[mIndex].isAnswer())) {
                    Toast.makeText(getApplicationContext(), "True!", Toast.LENGTH_SHORT).show();
                    mScore++;
                }
                else {
                    Toast.makeText(getApplicationContext(), "False!", Toast.LENGTH_SHORT).show();
                }

                updateQuestion();
            }
        };

        mTrueButton.setOnClickListener(onClickListener);
        mFalseButton.setOnClickListener(onClickListener);

        mIndex = 0;
        mScore = 0;
        mQuestionTextView.setText(mQuestionBank[mIndex].getQuestionID());
    }

    private void updateQuestion() {
        mIndex++;
        mQuestionTextView.setText(mQuestionBank[mIndex].getQuestionID());
    }
}
