package com.example.fragmentdataflow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private EditText editTextDataInput;

    public InputFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editTextDataInput = view.findViewById(R.id.editText_data);
        Button buttonSendData = view.findViewById(R.id.button_send);

        buttonSendData.setOnClickListener(v ->
        {
            String dataToSend = editTextDataInput.getText().toString();

            if (getActivity() != null && getActivity() instanceof MainActivity)
            {
                ((MainActivity) getActivity()).handleDataFromInputFragment(dataToSend);
            }
        });
        return view;
    }
}