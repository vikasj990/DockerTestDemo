package com.iceye.sbdb.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class ListenerImpl implements ITestListener {

    static Logger log;

    static {
        try {
            log = Logger.getLogger(Class.forName(ListenerImpl.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " Started.\n");
        log.info(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + "Execution Successfully completed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error(result.getName() + " failed. \n" + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(result.getName() + " Skipped Because of " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("=========== onFinish :-" + context.getName() + "===============");
    }

}
