package piyush.com.myappportofolio.adapters;

import java.util.ArrayList;

import piyush.com.myappportofolio.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by piyush on 21/11/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>
{
	ArrayList<String> dataSet;

	private MyViewHolder.MyClickListener listener;

	private LayoutInflater inflater;

	public MyRecyclerAdapter(ArrayList<String> dataSet, MyViewHolder.MyClickListener listener, Context context)
	{
		this.dataSet = dataSet;
		this.listener = listener;
		this.inflater = LayoutInflater.from(context);
	}

	/**
	 * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an item.
	 * <p/>
	 * This new ViewHolder should be constructed with a new View that can represent the items of the given type. You can either create a new View manually or inflate it from an XML
	 * layout file.
	 * <p/>
	 * The new ViewHolder will be used to display items of the adapter using {@link #onBindViewHolder(ViewHolder, int)}. Since it will be re-used to display different items in the
	 * data set, it is a good idea to cache references to sub views of the View to avoid unnecessary {@link View#findViewById(int)} calls.
	 *
	 * @param parent
	 *            The ViewGroup into which the new View will be added after it is bound to an adapter position.
	 * @param viewType
	 *            The view type of the new View.
	 * @return A new ViewHolder that holds a View of the given view type.
	 * @see #getItemViewType(int)
	 * @see #onBindViewHolder(ViewHolder, int)
	 */
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return new MyViewHolder(inflater.inflate(R.layout.btn_widget, parent, false), listener);
	}

	/**
	 * Called by RecyclerView to display the data at the specified position. This method should update the contents of the {@link ViewHolder#itemView} to reflect the item at the
	 * given position.
	 * <p/>
	 * Note that unlike {@link ListView}, RecyclerView will not call this method again if the position of the item changes in the data set unless the item itself is invalidated or
	 * the new position cannot be determined. For this reason, you should only use the <code>position</code> parameter while acquiring the related data item inside this method and
	 * should not keep a copy of it. If you need the position of an item later on (e.g. in a click listener), use {@link ViewHolder#getPosition()} which will have the updated
	 * position.
	 *
	 * @param holder
	 *            The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
	 * @param position
	 *            The position of the item within the adapter's data set.
	 */
	@Override
	public void onBindViewHolder(MyViewHolder holder, int position)
	{
		holder.button.setText(dataSet.get(position));
	}

	/**
	 * Returns the total number of items in the data set hold by the adapter.
	 *
	 * @return The total number of items in this adapter.
	 */
	@Override
	public int getItemCount()
	{
		return dataSet.size();
	}
}