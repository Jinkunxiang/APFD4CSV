# APFD4CSV
This is a small tool to calculate APFD (Average Percentage Fault Detection) metric. The fault, test case and sequence information should be saved as CSV files.

The **first parameter** is the location of fault and test case information (saved as one CSV file). The format like:  
| &nbsp; | f1 | f2 | f3 | f4 | f5 | f6 | f7 | f8 |
| - | - | -| - | - | - | - | - | - |
| t1 | 1 | &nbsp; | 1 | &nbsp; | &nbsp; | &nbsp; | &nbsp; | 1 |
| t2 | &nbsp; | &nbsp; | &nbsp; | &nbsp; | &nbsp; | &nbsp; | &nbsp; | &nbsp; |
| t3 | &nbsp; | 1 | &nbsp; | 1 | 1 | &nbsp; | &nbsp; | 1 |
| t4 | 1 | 1 | &nbsp; | &nbsp; | &nbsp; | 1 | &nbsp; | &nbsp; |
| t5 | &nbsp; | &nbsp; | 1 | &nbsp; | &nbsp; | &nbsp; | 1 | &nbsp; |  
  
The first line is the name of each fault. The first position of this line should be black.  
  
The following lines are the information of test cases. The first position is the name of the test case, and the following positions are whether the test case detected the corresponding fault (1 as detected, blank as not detected).

The **second parameter** is the location of the test case sequence within the test suite.  
  
Each line represents an individual test suite, the numeric order within each line corresponding to the test case order within the test suite.
  
A simple example is provided within the test.
