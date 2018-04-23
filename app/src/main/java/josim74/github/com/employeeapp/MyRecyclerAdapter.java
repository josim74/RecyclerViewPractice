package josim74.github.com.employeeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import josim74.github.com.employeeapp.createEmp.ProjectInteractor;

/**
 * Created by JosimUddin on 22/04/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    ArrayList<ProjectInteractor> projectList;
    Context context;

    public MyRecyclerAdapter(ArrayList<ProjectInteractor> projectList, Context context) {
        this.projectList = projectList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProjectInteractor projectInteractor = projectList.get(position);
        holder.name.setText(projectInteractor.getProjectName());
        holder.duration.setText(projectInteractor.getProjectDuration());
        holder.members.setText(projectInteractor.getNoOfMembers());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView duration;
        TextView members;
        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_project_name);
            duration = itemView.findViewById(R.id.tv_duration);
            members = itemView.findViewById(R.id.tv_members);
        }
    }
}
