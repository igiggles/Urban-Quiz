package gary.cregan.urbanquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import gary.cregan.urbanquiz.R;

public class MainMenuActivity extends Activity 
{
	private Button storyButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        
        this.storyButton = (Button)this.findViewById(R.id.storyModeButton);
        this.storyButton.setOnClickListener(new OnClickListener() {
          public void onClick(View v) 
          {
        	  Intent myIntent = new Intent(v.getContext(), UrbanQuizActivity.class);
              startActivityForResult(myIntent, 0);
          }
        });
    }
}
