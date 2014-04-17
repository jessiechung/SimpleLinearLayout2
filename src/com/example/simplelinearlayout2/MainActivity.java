package com.example.simplelinearlayout2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            //View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        	
        	LinearLayout ll = new LinearLayout(getActivity());
        	ll.setOrientation(LinearLayout.VERTICAL);
        	ll.setPadding(15, 15, 15, 15);

        	EditText toEditText = new EditText(getActivity());
        	toEditText.setHint("To");
        	
        	EditText sendEditText = new EditText(getActivity());
        	sendEditText.setHint("Subject");
        	
        	EditText msgEditText = new EditText(getActivity());
        	msgEditText.setHint("Message");
        	msgEditText.setGravity(Gravity.TOP);
        	
        	ll.addView(toEditText);
        	ll.addView(sendEditText);
        	ll.addView(msgEditText);  // 放入LinearLayout裡
        	
        	// EditText須先放入LinearLayout裡，才可取出LayoutParams去做設定修改
        	// 因為Layout是使用LinearLayout，故須將msgEditText.getLayoutParams()轉成LinearLayout.LayoutParams
        	LinearLayout.LayoutParams msgParams = (LinearLayout.LayoutParams) msgEditText.getLayoutParams(); // 取出LayoutParams
        	msgParams.weight = 1;
        	
        	Button button = new Button(getActivity());
			button.setText("Send");
			ll.addView(button);
			
			LinearLayout.LayoutParams buttonParams = (LinearLayout.LayoutParams) button.getLayoutParams();
			buttonParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
			buttonParams.gravity = Gravity.RIGHT;
        	
        	return ll;
            //return rootView;
        }
    }

}
