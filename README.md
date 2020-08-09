# Android_Practice
These are practices for Android with Java. 



## Sorted the projects that I even finished

- android_HW4_datepicker_20180626
- android_practice_mydialog_20180621
- android_course_20180627 
- Homework1_0626 
- android_course_20180628 
- android_course_20180629
- android_course_20180704 
- android_course_20180705 
- android_course_20180706
- Android-with-java-practice



## Git step-by-step

- Purpose: Moved the above repositories to this repository

- Folder Configuration:

  ```
  -- Android_Practice/
  |- repo1/
  |- repo2/
  |- repo3/
  ...
  ```

- Step: (In the folder of "Android_Practice")

1.  `git remote add other1 ../repo1`
2. `git fetch other1`
3. `git checkout -b repo1_branch other1/master`
4. `git checkout master`
5. `git merge repo1_branch --allow-unrelated-histories`

- Reference:
  - [解决Git中fatal: refusing to merge unrelated histories](https://blog.csdn.net/wd2014610/article/details/80854807)
  - [合併兩個git倉庫](https://blog.csdn.net/gouboft/article/details/8450696)

