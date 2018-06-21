package com.example.matiasbueno.jobschedulertest;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.i("MyJobService","Starting JOB: " + params.getJobId());
        return false;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        return false;
    }
}
