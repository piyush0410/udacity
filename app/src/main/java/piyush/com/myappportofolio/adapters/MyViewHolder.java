package piyush.com.myappportofolio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import piyush.com.myappportofolio.R;

/**
 * Created by piyush on 21/11/15.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
	public interface MyClickListener
	{
		public void onItemClick(View v, int position);
	}

	Button button;

	MyClickListener myClickListener;

	public MyViewHolder(View itemView, MyClickListener listener)
	{
		super(itemView);
		this.button = (Button) itemView.findViewById(R.id.btn);
		this.myClickListener = listener;
		this.button.setOnClickListener(this);
	}

	/**
	 * Called when a view has been clicked.
	 *
	 * @param v
	 *            The view that was clicked.
	 */
	@Override
	public void onClick(View v)
	{
		if (myClickListener != null)
		{
			myClickListener.onItemClick(v, getPosition());
		}
	}
}
