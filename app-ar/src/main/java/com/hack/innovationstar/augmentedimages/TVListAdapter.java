package com.hack.innovationstar.augmentedimages;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samsung.multiscreen.Service;

public class TVListAdapter extends ArrayAdapter<Service> {

    private Context context;
    private int layoutResourceId;
    private LayoutInflater mInflater;

    public TVListAdapter(Context context, int resourceId) {
        super(context, resourceId);
        this.context = context;
        this.layoutResourceId = resourceId;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public boolean contains(Service service) {
        return (getPosition(service) >= 0);
    }

    public void replace(Service service) {
        int position = getPosition(service);
        if (position >= 0) {
            remove(service);
            insert(service, position);
        }
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Log.d("Entrou", "---------------> TVListAdapter()<---------------------------");

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(layoutResourceId, parent, false);
            holder.name = convertView.findViewById(R.id.name);
            holder.ip = convertView.findViewById(R.id.ip);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Service service = getItem(position);
        holder.name.setText(service.getName());
        holder.ip.setText(service.getUri().toString());

        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView ip;
    }
}
