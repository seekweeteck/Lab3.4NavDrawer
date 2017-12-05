package my.edu.tarc.lab34navdrawer;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {
    private static final int REQUEST_PHOTO = 1;
    private ImageView imageViewPhoto;

    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_import, container, false);

        imageViewPhoto = (ImageView) v.findViewById(R.id.imageViewPhoto);

        Button buttonPhoto = (Button) v.findViewById(R.id.buttonPhoto);

        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Filter to only show results that can be "opened"
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // Filter to show only images, using the image MIME data type.
                intent.setType("image/*");

                startActivityForResult(intent, REQUEST_PHOTO);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_PHOTO && resultCode == Activity.RESULT_OK){
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (data != null) {
                uri = data.getData();

                imageViewPhoto.setImageURI (uri);

            }
        }
    }
}
