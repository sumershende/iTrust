dir='src/main/edu/ncsu/csc/itrust'
dir_main='iTrust'
cd $dir_main
git checkout testcases
max=1 #Number of testcase iterations
file="ParameterUtil.java"
for ((i=1; i <= $max; ++i))
do
	cd $dir
	input_num=$(( ( RANDOM % 50 )  + 20 )) #Choosing random number of files between 1-10
	for ((j=1; j<=$input_num; ++j))
	do
		#file=`grep -lR --include=*.java "for (.*)" | shuf -n 1`
		#file=`find . -type f -name '*.java' | shuf -n 1`
		op_num=$(( ( RANDOM % 8 ) )) #Choosing random operation (1=string replace 2=swap < with >)
		if (($op_num == 1))
		then
			file=`find . -type f -name '*.java' | shuf -n 1`
			rand=$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 32 | head -n 1)
			sed -i 's/"[^"]*"/"$rand"/g' $file
		fi
		if (($op_num == 2))
		then
			file=`grep -lR --include=*.java "for (.*;.*<.*;.*)" | shuf -n 1`
			sed -i 's/for\(.*\)</for\1>/g' $file
		fi
		if (($op_num == 3))
		then
			file=`grep -lR --include=*.java "if (.*<.*)" | shuf -n 1`
			sed -i 's/if\(.*\)</if\1>/g' $file
		fi
		if (($op_num == 4))
		then
			file=`grep -lR --include=*.java "if (.*==.*)" |shuf -n 1`
			sed -i 's/if\(.*\)==/if\1!=/g' $file
		fi
		if (($op_num == 5))
		then
			file=`grep -lR --include=*.java "for (.*;.*>.*;.*)" | shuf -n 1`
			sed -i 's/for\(.*\)>/for\1</g' $file
		fi
		if (($op_num == 6))
		then
			file=`grep -lR --include=*.java "if (.*>.*)" | shuf -n 1`
			sed -i 's/if\(.*\)>/if\1</g' $file
		fi
		if (($op_num == 7))
		then
			file=`grep -lR --include=*.java "if (.*!=.*)" |shuf -n 1`
			sed -i 's/if\(.*\)!=/if\1==/g' $file
		fi
		echo "$input_num $op_num $file"
	done
	cd ~
	cd $dir_main
	git checkout testcases
	git add .
	git commit -am "Testcase"
	git push -f origin testcases
	sleep 3m
	git checkout testcases
	git fetch --all
	git reset --hard origin/master	
done
git checkout testcases
git add .
git commit -am "Finished"
git push origin testcases
