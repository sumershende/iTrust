import re
import json
import codecs
f1=codecs.open("target/site/jacoco/index.html", 'r')
page=f1.read()
start=page.index("Total")
totalIndex=page.index("ctr2", start)
totalIndexEnd=page.index("<", totalIndex)
totalLine=page[totalIndex+6:totalIndexEnd]
#print("Line",totalLine)
start=totalIndexEnd
totalIndex=page.index("ctr2", start)
totalIndexEnd=page.index("<", totalIndex)
totalBranch=page[totalIndex+6:totalIndexEnd]
#print("Branch",totalBranch)







pat = re.compile(r'<table(.*?)>(.*)')
f = open('target/site/surefire-report.html')
for line in f:
	if pat.match(line):
		break
found=False
pat = re.compile(r'<tr class="b"')
for line in f:
	if pat.match(line):
		break

tests = f.next()[4:-6]
err = f.next()[4:-6]
failures = f.next()[4:-6]
skipped = f.next()[4:-6]
succ_rate = f.next()[4:-6]
time = f.next()[4:]
time = time[:time.index('<')]




pat = re.compile(r'<h2><a name="Failure_Details"></a>Failure Details</h2><a name="Failure_Details"></a>')
for line in f:
    if pat.match(line):
    	found = True
    	break

failure_details = []
if found:
	for line in f:
		if line[0:6] == '<td><a':
			failure_details.append(re.search(r'</a>\w+</', line).group()[4:-2])
			
with open('/home/ubuntu/tests.json') as f2:
    data = json.load(f2)
count=data["count"]

alltests=[]
if data["count"]==0:
	f=codecs.open("target/site/surefire-report.html", 'r')
	page=f.read()
	starting=page.index('<a name="Test_Cases">')
	ending=page.find("Failure Details")
	if ending==-1:
		ending=len(page)
	tending=ending
	counter=0
	while page.find('class="section"',starting,ending) !=-1 :
		starting=page.find("<tr class=",starting,tending)
		if starting ==-1:
			starting=page.find("<tr class=",tending)

		tending=page.find("</div>",starting,ending)
		tending1=page.find("</tr>",starting,tending)
		istarting=page.find("</a>test",starting,tending1)
		if istarting==-1:
			istarting=page.find("</a>get",starting,tending1)
		if istarting==-1:
			starting=page.find("<tr class=",tending+10)
			
			tending=page.find("</div>",starting,ending)
			tending1=page.find("</tr>",starting,tending)
			istarting=page.find("</a>test",starting,tending1)
			if istarting==-1:
				istarting=page.find("</a>get",starting,tending1)
		iending=page.find("</td>",istarting,tending1)
		t=page[istarting+4:iending]
		alltests.append(t)
		starting=iending
		counter+=1
		tending=page.find('class="section"',starting,ending)     
		if tending==-1:
			tending=ending
	

alltests.extend(failure_details)
print("Total Count",len(alltests))
data["count"]+=1
if data["count"]==1:
	main_json = {"alltests":alltests,count:{'lineCover':totalLine,'branchCover':totalBranch, 'tests':tests,'error':err,'failures':failures,'skipped':skipped,'succ_rate':succ_rate,'time':time,'Failure Details': failure_details}}
#print("Count",count)
else:
	main_json = {count:{'lineCover':totalLine,'branchCover':totalBranch, 'tests':tests,'error':err,'failures':failures,'skipped':skipped,'succ_rate':succ_rate,'time':time,'Failure Details': failure_details}}
#print(main_json)
data.update(main_json)
print(data)

with open('/home/ubuntu/tests.json', 'w') as f2:
    json.dump(data, f2)
