package com.hack.innovationstar.augmentedimages;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.samsung.multiscreen.Message;

import org.json.JSONObject;

public class SelectPlayCategoryFragment extends Fragment implements View.OnClickListener
{
    private Button btnBody, btnDaily, btnCores;
    private String selectedCategoryforPlay;
    private String playerType;
    private String clientID;
    ArActivity arActivity=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_select_play_category, null);

        Bundle bundle = getArguments();
        playerType = bundle.getString("selectPlayer");
        clientID = bundle.getString("clientID");

        btnCores =(Button) v.findViewById(R.id.btn_Cores);
        btnDaily =(Button) v.findViewById(R.id.btn_Daily);
        btnBody =(Button)v.findViewById(R.id.btn_Body);

        // v.setOnClickListener(this);

           /* v.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                    if( keyCode == KeyEvent.KEYCODE_BACK )
                    {


                        return true;
                    }
                    return true;
                }
            });*/
        Log.d("Entrou", "---------------> SelectPlayCategoryFragment.java<---------------------------");
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        initializeListner();
    }


    @Override
    public void onClick(View v)
    {
        if(v.equals(btnBody))
        {
            selectedCategoryforPlay="Body";
            //Toast.makeText(getActivity(), "Corpo!!!!", Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Teste!!",Toast.LENGTH_LONG).show();

            JSONObject jsonObj = null;

            try
            {
                jsonObj = new JSONObject();
                jsonObj.put("categoryType", "body");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            String messageSend = jsonObj.toString();
            Log.v(App.TAG, messageSend);
            ChoosePlayerActivity.application.publish("say", messageSend, Message.TARGET_HOST);
            Log.d("Here", "---------------> SelectPlayCategoryFragment.java<---------------------------");
            if(playerType.equals("MultiPlayer"))
            {
                ((ChoosePlayerActivity)getActivity()).launchWaitScreenFrag();
            }
//
            // ChoosePlayerActivity.application.publish("say", selectedCategoryforPlay, Message.TARGET_HOST);
            // ChoosePlayerActivity.application.disconnect();
            startActivity(new Intent(getContext(),ArActivity.class));
        }

        else if(v.equals(btnDaily))
        {
            selectedCategoryforPlay="Daily";
            Toast.makeText(getActivity(), "Daily!!!!", Toast.LENGTH_LONG).show();
            JSONObject jsonObj = null;
            try
            {
                jsonObj = new JSONObject();
                jsonObj.put("categoryType", "daily");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            String messageSend = jsonObj.toString();
            Log.v(App.TAG, messageSend);
            ChoosePlayerActivity.application.publish("say", messageSend, Message.TARGET_HOST);

            if(playerType.equals("MultiPlayer"))
            {
                ((ChoosePlayerActivity)getActivity()).launchWaitScreenFrag();
            }
        }

        else if(v.equals(btnCores))
        {
            selectedCategoryforPlay="Cores";
            Toast.makeText(getActivity(), "Cores!!!!", Toast.LENGTH_LONG).show();

            JSONObject jsonObj = null;
            try
            {
                jsonObj = new JSONObject();
                jsonObj.put("categoryType", "cores");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            String messageSend = jsonObj.toString();
            Log.v(App.TAG, messageSend);
            ChoosePlayerActivity.application.publish("say", messageSend, Message.TARGET_HOST);

            if(playerType.equals("MultiPlayer"))
            {
                ((ChoosePlayerActivity)getActivity()).launchWaitScreenFrag();
            }
        }
        Log.d("Here", "---------------> SelectPlayCategoryFragment.java Errorrrrr<---------------------------");

    }

    public void initializeListner()
    {
        btnBody.setOnClickListener(this);
        btnDaily.setOnClickListener(this);
        btnCores.setOnClickListener(this);
    }


}

