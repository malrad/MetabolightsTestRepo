A reusable bash script that removes/replaces special characters in
filenames (unsafe characters are either removed or replaced by a substitute set in the optional
`options` object argument).

Sample Input:
tmp/test1_#_*_1.txt

Output:
test1poundasterisk1.txt

How to run
sh file_rename_script.sh  tmp -\# -\*
