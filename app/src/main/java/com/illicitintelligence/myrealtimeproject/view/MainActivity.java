package com.illicitintelligence.myrealtimeproject.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.illicitintelligence.myrealtimeproject.R;
import com.illicitintelligence.myrealtimeproject.model.Message;
import com.illicitintelligence.myrealtimeproject.viewmodel.RealViewModel;

public class MainActivity extends AppCompatActivity {


    private RealViewModel viewModel;
    private Observer<Message> messageObserver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewModel = ViewModelProviders.of(this).get(RealViewModel.class);

        messageObserver = new Observer<Message>() {
            @Override
            public void onChanged(Message message) {
                addMessage(message);
            }
        };

        viewModel.getLiveData().observe(this, messageObserver);

//        Message x = new Message();
//        x.setMessageContent("Hello there. GM, GA, GN!");
//        x.setMessageDate("12/20/2020");
//        x.setMessageTitle("Latest Message");
//        x.setUserName("DaloChink");


//        viewModel.sendRealMessage(x);

    }


    private void addMessage(Message message) {

        Log.d("TAG_X", "Message: " + message.getMessageContent());

    }
}
