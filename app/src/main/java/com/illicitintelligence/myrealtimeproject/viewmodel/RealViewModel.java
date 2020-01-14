package com.illicitintelligence.myrealtimeproject.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.illicitintelligence.myrealtimeproject.model.Message;
import com.illicitintelligence.myrealtimeproject.util.Constants;

public class RealViewModel extends AndroidViewModel {

    private DatabaseReference messageReference;
    private MutableLiveData<Message> messageMutableLiveData = new MutableLiveData<>();

    public RealViewModel(@NonNull Application application) {
        super(application);

        messageReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH);

        messageReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot currentData : dataSnapshot.getChildren()){
                    messageMutableLiveData.setValue(currentData.getValue(Message.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.d("TAG_X", " "+ databaseError.getMessage());
//              TODO: Show error
            }
        });
    }

    public void sendRealMessage(Message message){
        String childKey = messageReference.push().getKey();
        if(childKey != null)
            messageReference.child(childKey).setValue(message);
    }

    public MutableLiveData<Message> getLiveData(){
        return messageMutableLiveData;
    }

}
