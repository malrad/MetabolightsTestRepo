#!/bin/bash

script="file_rename_script.sh"

mandatory_args=1

function usage() {

	echo  "usage: $script MANDATORY [OPTION]\n"

}

function example() {
	echo  "example: $script <filepath> -\# -\%" 
}

function help {
	usage
	echo  "MANDATORY:"
	echo  "--mandatory value filepath/folder to remove the special characters in the file name"
	echo  "OPTION:"
	echo  "--optional # pound"
	echo  "--optional % percent"
	echo  "---optional & ampersand"
	echo  "--optional { leftcurlybracket"
	echo  "--optional } rightcurlybracket"
	echo  "--optional \ backslash"
	echo  "---optional < leftanglebracket"
	echo  "--optional > rightanglebracket"
	echo  "--optional * asterisk"
	echo  "--optional ? questionmark"
	echo  "--optional / forwardslash"
	echo  "--optional  blankspaces"
	echo  "--optional $ dollarsign"
	echo  "--optional ! exclamationpoint" 
	echo  "--optional @ atsign"
	echo  "--optional + plussign"
	echo  "--optional \` backtick"
	echo  "--optional | pipe"
	echo  "--optional = equalsign"
	echo  "--optional _ underscore"

}

function mandatoryargs_precheck() {
	if [ $# -lt $mandatory_args ] || [ $# -gt $mandatory_args ];
	then
		usage
		example
		exit 1
	elif [ $1 ]; then 
		if [ $1 == "--help" ] || [ $1 == "--h" ]; then
			help
			exit 1
		fi
	else
		usage
		example
		exit 1
	fi

}


mandatoryargs_precheck $1

file_path=$1
shift 1

if [ -d "$file_path" ] ; then 
	
	for file in "$file_path"/*; do 
		
		if [ -f "$file" ]; then
	
			file_name_with_extension="$(basename "$file")"
			extension="${file_name_with_extension##*.}"
			file_name="${file_name_with_extension%.*}"

			while getopts '#%&_{}\\<>*?\/ $!@+\`|=' OPTION; do
			  	case "$OPTION" in
    					\#)
			      			file_name=${file_name//[#]/pound}
						;;

    					\%)
      						file_name=${file_name//[%]/percent}
                        			;;

    					\&)
      						file_name=${file_name//[&]/ampersand}
      						;;
    					\_)
      						file_name=${file_name//[_]/underscore}
                        			;;
					\{)
                        			file_name=${file_name//[{]/leftcurlybracket}
                        			;;

                			\})
                        			file_name=${file_name//[\}]/rightcurlybracket}
                        			;;

                			\\)
                        			file_name=${file_name//[\\]/backslash}
                        			;;
                			\<)
                        			file_name=${file_name//[<]/leftanglebracket}
                        			;;
					\>)
                        			file_name=${file_name//[>]/rightanglebracket}
                        			;;
					\*)
                        			file_name=${file_name//[*]/asterisk}
                        			;;

                			\?)
                        			file_name=${file_name/[?]/questionmark}
                        			;;
                			\/)
                        			file_name=${file_name//[\/]/forwardslash}
                        			;;
                			\ )
						file_name=${file_name//[\ ]/blanckspaces}
                        			;;
					\$)
                        			file_name=${file_name//[\$]/dollarsign}
                        			;;

                			\!)
                        			file_name=${file_name/[\!]/exclamationpoint}
                        			;;
                			\@)
                        			file_name=${file_name//[@]/atsign}
                        			;;
                			\|)
                        			file_name=${file_name//[|]/pipe}
                        			;;
                			\=)
                        			file_name=${file_name//[=]/equalsign}
                        			;;

                			\`)
                        			file_name=${file_name/[\`]/backtick}
                        			;;

  				esac
			done

			echo "file name renmaed : $file_name"
			file_name=${file_name//[^[:alnum:]]/}
			$( mv -i "$file" "$file_path/$file_name.$extension")
		else 
			echo "$file is not a file"
		fi
	done
else
	echo "The passed argument is not a directory"
fi	


