$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SuccessFactorLMS.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: shahnawaz.sarkar@pwc.com"
    }
  ],
  "line": 2,
  "name": "SAP Successfactor PoC on LMS Module",
  "description": "",
  "id": "sap-successfactor-poc-on-lms-module",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "User request new classroom schedule for course",
  "description": "",
  "id": "sap-successfactor-poc-on-lms-module;user-request-new-classroom-schedule-for-course",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@TestScript1"
    },
    {
      "line": 5,
      "name": "@ClassroomCourseRequestSchedule"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User launches the Success Factor demo URL for LMS",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User Enters credentials for \"lms_user\" and \"lms_pwd\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User Clicks on \"\u003cLink\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User Searches for \"\u003cCourseName\u003e\" from catalogue",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User expands the \"\u003cCourseName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User selects \"\u003cAssignmentOption\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the course should gets added under my learning Assignments with \"\u003cCourseName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User selects option \"\u003cAction\u003e\" on \"\u003cCourseName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User should be able to Request an schedule",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "sap-successfactor-poc-on-lms-module;user-request-new-classroom-schedule-for-course;",
  "rows": [
    {
      "cells": [
        "Link",
        "Filter",
        "CourseName",
        "AssignmentOption",
        "Action"
      ],
      "line": 18,
      "id": "sap-successfactor-poc-on-lms-module;user-request-new-classroom-schedule-for-course;;1"
    },
    {
      "cells": [
        "Browse all courses",
        "Instructor Led",
        "International Marketing",
        "Assign to Me",
        "Request Schedule"
      ],
      "line": 19,
      "id": "sap-successfactor-poc-on-lms-module;user-request-new-classroom-schedule-for-course;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1346000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "User request new classroom schedule for course",
  "description": "",
  "id": "sap-successfactor-poc-on-lms-module;user-request-new-classroom-schedule-for-course;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@TestScript1"
    },
    {
      "line": 5,
      "name": "@ClassroomCourseRequestSchedule"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User launches the Success Factor demo URL for LMS",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User Enters credentials for \"lms_user\" and \"lms_pwd\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User Clicks on \"Browse all courses\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User Searches for \"International Marketing\" from catalogue",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User expands the \"International Marketing\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User selects \"Assign to Me\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the course should gets added under my learning Assignments with \"International Marketing\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User selects option \"Request Schedule\" on \"International Marketing\"",
  "matchedColumns": [
    2,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User should be able to Request an schedule",
  "keyword": "Then "
});
formatter.match({
  "location": "SuccessFactorLMSModule.user_launches_the_Success_Factor_demo_URL_for_LMS()"
});
formatter.result({
  "duration": 11539846400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lms_user",
      "offset": 29
    },
    {
      "val": "lms_pwd",
      "offset": 44
    }
  ],
  "location": "SuccessFactorLMSModule.user_Enters_credentials_for_and(String,String)"
});
formatter.result({
  "duration": 11572485800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Browse all courses",
      "offset": 16
    }
  ],
  "location": "SuccessFactorLMSModule.user_Clicks_on(String)"
});
formatter.result({
  "duration": 11882275800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "International Marketing",
      "offset": 19
    }
  ],
  "location": "SuccessFactorLMSModule.user_Searches_for_from_catalogue(String)"
});
formatter.result({
  "duration": 21346576300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "International Marketing",
      "offset": 18
    }
  ],
  "location": "SuccessFactorLMSModule.user_expands_the(String)"
});
formatter.result({
  "duration": 4406270300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Assign to Me",
      "offset": 14
    }
  ],
  "location": "SuccessFactorLMSModule.user_selects(String)"
});
formatter.result({
  "duration": 4085199800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "International Marketing",
      "offset": 65
    }
  ],
  "location": "SuccessFactorLMSModule.the_course_should_gets_added_under_my_learning_plan_with_(String)"
});
formatter.result({
  "duration": 8975705500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Request Schedule",
      "offset": 21
    },
    {
      "val": "International Marketing",
      "offset": 43
    }
  ],
  "location": "SuccessFactorLMSModule.user_selects_option_on(String,String)"
});
formatter.result({
  "duration": 3030550700,
  "status": "passed"
});
formatter.match({
  "location": "SuccessFactorLMSModule.user_should_be_able_to_Request_an_schedule()"
});
formatter.result({
  "duration": 19673800,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//iframe[@id\u003d\u0027scheduleRequestBuffer\u0027]\"}\n  (Session info: chrome\u003d76.0.3809.100)\n  (Driver info: chromedriver\u003d2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e),platform\u003dWindows NT 10.0.17763 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 15 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.45.0\u0027, revision: \u00275017cb8e7ca8e37638dc3091b2440b90a1d8686f\u0027, time: \u00272015-02-27 09:10:26\u0027\nSystem info: host: \u0027INPC0STFTV\u0027, ip: \u002710.133.148.151\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:2578}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e), userDataDir\u003dC:\\Users\\SHAHNA~1\\AppData\\Local\\Temp\\scoped_dir30020_27917}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d76.0.3809.100, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 023c2f1db9b41d4485ceba09795589e5\n*** Element info: {Using\u003dxpath, value\u003d//iframe[@id\u003d\u0027scheduleRequestBuffer\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor14.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:449)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:357)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\r\n\tat pageActions.SF_LMS_CourseRegisterActions.requestSchedule(SF_LMS_CourseRegisterActions.java:53)\r\n\tat lmsStepDefinitions.SuccessFactorLMSModule.user_should_be_able_to_Request_an_schedule(SuccessFactorLMSModule.java:153)\r\n\tat ✽.Then User should be able to Request an schedule(SuccessFactorLMS.feature:15)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4685871400,
  "status": "passed"
});
});