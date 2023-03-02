# try
# make it
# make test
# make CLItest
  
it:
	javac CLI.java 

test:
	javac TestAsn1.java 
	java TestAsn1

CLItest:
	cat testfile | java asn4/CLI -a BOOK "Star Trek" 1.99 Bill SCIFI USED | java asn4/CLI -d -t "Star Trek"

table:
	cat testfile | java asn4/CLI -s -a Asimov | sed -e 's/;/,/g' | csvlook


