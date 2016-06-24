package com.example.mromesa.assignments1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.mromesa.assignments1.R.id.imageView1;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AssignmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AssignmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AssignmentFragment extends Fragment {

    //cam
    private static final int CAMERA_REQUEST = 1888;
    //private ImageView imageView;


    public AssignmentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_assignment, container, false);


        final ImageView imageView = (ImageView)view.findViewById(imageView1);
        Button photoButton = (Button) view.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);


                }


            //for some reason this is not being called

            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(photo);

                }

            }


        });



        return view;
    }



}
