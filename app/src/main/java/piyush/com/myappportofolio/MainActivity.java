package piyush.com.myappportofolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import piyush.com.myappportofolio.adapters.MyRecyclerAdapter;
import piyush.com.myappportofolio.adapters.MyViewHolder;
import piyush.com.myappportofolio.adapters.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

		ArrayList<String> dataSet = new ArrayList<String>(5);
		dataSet.add(new String("SPOTIFY STREAMER"));
		dataSet.add(new String("SCORES APP"));
		dataSet.add(new String("LIBRARY APP"));
		dataSet.add(new String("BUILD IT BIGGER"));
		dataSet.add(new String("XYZ READER"));
		dataSet.add(new String("CAPSTONE: MY OWN APP"));

		MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataSet,
				new MyViewHolder.MyClickListener()
				{
					@Override
					public void onItemClick(View v, int position)
					{
						if (v instanceof Button)
						{
							String text = (String) ((Button) v).getText();
							Toast.makeText(MainActivity.this,
									"This button will launch " + text + "!", Toast.LENGTH_SHORT)
									.show();
						}
					}
				}, getApplicationContext());

		recyclerView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
