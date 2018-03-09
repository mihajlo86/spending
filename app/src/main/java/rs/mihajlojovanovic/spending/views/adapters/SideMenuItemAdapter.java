package rs.mihajlojovanovic.spending.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rs.mihajlojovanovic.spending.R;

public class SideMenuItemAdapter extends ArrayAdapter<SideMenuItem> {

    private final Context ctx;
    private final int layoutResourceId;
    private List<SideMenuItem> sideMenuItems;

    public SideMenuItemAdapter(Context ctx, int layoutResourceId, List<SideMenuItem> sideMenuItems)
    {
        super(ctx, layoutResourceId, sideMenuItems);
        this.layoutResourceId = layoutResourceId;
        this.ctx = ctx;
        this.sideMenuItems = sideMenuItems;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceId, null);
            holder = new ViewHolder();
            if (position == 0)
                convertView.setBackgroundColor(ctx.getResources().getColor(R.color.vpi__background_holo_light));
            holder.ivIcon = convertView.findViewById(R.id.imageViewIcon);
            holder.tvLabel = convertView.findViewById(R.id.textViewLabel);
            holder.tvNotification = convertView.findViewById(R.id.textViewNotification);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();
        if ((sideMenuItems == null) || ((position + 1) > sideMenuItems.size()))
            return convertView;
        SideMenuItem item = sideMenuItems.get(position);
        holder.tvLabel.setText(item.getLabel());
        holder.ivIcon.setImageResource(item.getIcon());
        if (item.getNotificationsCount() > 0)
        {
            holder.tvNotification.setVisibility(View.VISIBLE);
            if (item.getNotificationsCount() < 100)
                holder.tvNotification.setText(item.getNotification());
            else
                holder.tvNotification.setText(R.string.more_than_99);
        }
        else
            holder.tvNotification.setVisibility(View.GONE);
        return convertView;
    }

    private class ViewHolder
    {
        private ImageView ivIcon;
        private TextView tvLabel;
        private TextView tvNotification;
    }

}
