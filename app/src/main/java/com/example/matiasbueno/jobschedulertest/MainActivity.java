package com.example.matiasbueno.jobschedulertest;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private JobScheduler jobScheduler;
    private JobInfo jobInfoInstant1;
    private JobInfo jobInfoInstant2;
    private JobInfo jobInfoPeriodic;
    private ComponentName serviceComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceComponent = new ComponentName(this, MyJobService.class);

        PersistableBundle extras = new PersistableBundle();
        jobInfoInstant1 = new JobInfo.Builder(1, serviceComponent)
                .setRequiresDeviceIdle(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)
                .setExtras(extras)
                .setPersisted(true)
                .build();

        jobInfoInstant2 = new JobInfo.Builder(2, serviceComponent)
                .setRequiresDeviceIdle(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)
                .setExtras(extras)
                .setPersisted(true)
                .build();

        jobInfoPeriodic = new JobInfo.Builder(3, serviceComponent)
                .setRequiresDeviceIdle(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)
                .setExtras(extras)
                .setPersisted(true)
                .setPeriodic(15*60*1000) //minimum 15 minutes since Android N
                .build();

        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

    }

    public void scheduleJobInstant1(View view) {
        Log.i("Main","Scheduling JOB PERSISTED 1");
        jobScheduler.schedule(jobInfoInstant1);
    }

    public void scheduleJobInstant2(View view) {
        Log.i("Main","Scheduling JOB PERSISTED 2");
        jobScheduler.schedule(jobInfoInstant2);
    }

    public void scheduleJobPeriodic(View view) {
        Log.i("Main","Scheduling JOB PERIODIC 3");
        jobScheduler.schedule(jobInfoPeriodic);
    }

}
