#Author: shahnawaz
Feature: SAP Successfactor PoC on LMS Module


  @TestScript1 @ClassroomCourseRequestSchedule
  Scenario Outline: User request new classroom schedule for course
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User Clicks on "<Link>"
    And User Searches for "<CourseName>" from catalogue
    And User expands the "<CourseName>"
    When User selects "<AssignmentOption>"
    And the course should gets added under my learning Assignments with "<CourseName>"
    And User selects option "<Action>" on "<CourseName>"
    Then User should be able to Request an schedule

    Examples: 
      | Link               | Filter         | CourseName              | AssignmentOption | Action           |
      | Browse all courses | Instructor Led | International Marketing | Assign to Me     | Request Schedule |

  @TestScript2 @AssignCourse
  Scenario Outline: User Self Assign a course by browsing catalogue
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User Clicks on "<Link>"
    And User Searches for "<CourseName>" from catalogue
    And User expands the "<CourseName>"
    #And User clicks on the "<CourseName>" to check and "<AssignmentOption>" the prerequisite
    When User selects "<AssignmentOption>"
    Then the course should gets added under my learning Assignments with "<CourseName>"

    Examples: 
      | Link               | CourseName            | AssignmentOption |
      | Browse all courses | Premium Service Plans | Assign to Me     |

  @TestScript3 @AssignClassroomCourse
  Scenario Outline: User self-registers to a classroom course by browsing catalogue
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User Clicks on "<Link>"
    And User Applies "<Filter>" category to select "<CourseName>"
    When User Registers on the Course with an available scheduled offering
    Then the course should gets added under my learning Assignments with "<CourseName>"

    Examples: 
      | Link               | Filter         | CourseName                   |
      | Browse all courses | Instructor Led | Standards of Ethical Conduct |

  @TestScript4.1 @SupervisorAssignCourse
  Scenario Outline: Supervisor assigns course to subordinate/direct reports
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User navigates to a "<Tab>"
    And User Clicks on "<Link>"
    And User performs an action "<Action>"
    When User adds or removes "<Employee>" and add "<Items>" with "<AssignmentType>" to learning plan
    Then the course should gets added or removed under "<Employee>" learning plan with "<Items>"

    Examples: 
      | Tab          | Link                   | Action          | Employee       | Items              | AssignmentType   |
      | My Employees | Assign/Remove Learning | Assign Learning | Emelda B Akers | Basic Preparedness | Manager Required |

  @TestScript4.2 @SupervisorRemoveCourse
  Scenario Outline: Supervisor removes course from subordinate/direct reports
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User navigates to a "<Tab>"
    And User Clicks on "<Link>"
    And User performs an action "<Action>"
    When User adds or removes "<Employee>" and add "<Items>" with "<AssignmentType>" to learning plan
    Then the course should gets added or removed under "<Employee>" learning plan with "<Items>"

    Examples: 
      | Tab          | Link                   | Action                   | Employee       | Items              | AssignmentType   |
      | My Employees | Assign/Remove Learning | Remove Assigned Learning | Emelda B Akers | Basic Preparedness | Manager Required |

  @TestScript5.1 @SupervisorAssignScheduledCourse
  Scenario Outline: Supervisor registers subordinate/direct reports into a scheduled offering
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User navigates to a "<Tab>"
    And User Clicks on "<Link>"
    And User performs an action "<Action>"
    When User registers or withdraws "<Employee>" and add "<Items>" with "<Notification>" to learning plan
    Then the course should gets added or removed under "<Employee>" learning plan with "<Items>"

    Examples: 
      | Tab          | Link                        | Action             | Employee       | Items                  | Notification |
      | My Employees | Register/Withdraw Employees | Register Employees | Emelda B Akers | Situational Leadership | Learners     |

  @TestScript5.2 @SupervisorWithdrawScheduledCourse
  Scenario Outline: Supervisor registers subordinate/direct reports into a scheduled offering
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And User navigates to a "<Tab>"
    And User Clicks on "<Link>"
    And User performs an action "<Action>"
    When User registers or withdraws "<Employee>" and add "<Items>" with "<Notification>" to learning plan
    Then the course should gets added or removed under "<Employee>" learning plan with "<Items>"

    Examples: 
      | Tab          | Link                        | Action             | Employee       | Items                  | Notification |
      | My Employees | Register/Withdraw Employees | Withdraw Employees | Emelda B Akers | Situational Leadership | Learners     |

  #Change code to select status for approved course [Last step of the scenario] ~ done
  @TestScript7 @ClassRoomCourseWithdraw
  Scenario Outline: Supervisor Approves  User Withdrawl on a ClassRoom Course
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    And user performs withdraw action on the course "<ActionB>" "<CancellationReason>"

    Examples: 
      | CourseName                   | ActionB  | CancellationReason         |
      | Standards of Ethical Conduct | Withdraw | Personal Reason (PERSONAL) |

  #Run Sceanio 3 for ClassRoomCourseAssign and Scenario 6 for Approval process
  #Run Sceanio 7 for ClassRoomCourseWithdraw and Scenario 7.3 for Approval process
  @TestScript6 @ClassRoomCourseSupervisorApproval @TestScript7.3
  Scenario Outline: Supervisor Approves  User Registration on a ClassRoom Course
    Given User launches the Success Factor demo URL for LMS
    And Supervisor Enters credentials for "lms_supervisor" and "lms_pwd"
    And User Clicks on "<Link>"
    When Supervisor selects an action "<Action>"

    Examples: 
      | Link             | Action  |
      | pending approval | Approve |

  @TestScript6.4 @ConfirmEnrolledStatus
  Scenario Outline: validates the enrollment status for the ClassRoom Course
    Given User launches the Success Factor demo URL for LMS
    And User Enters credentials for "lms_user" and "lms_pwd"
    Then User selects the enrolled course "<Course>" to validate status

    Examples: 
      | Course                       |
      | Standards of Ethical Conduct |
