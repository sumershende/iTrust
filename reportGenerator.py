import json
with open('tests.json') as f2:
    data = json.load(f2)
count=data["count"]
alltests=data["alltests"]
print "no of tests",len(alltests)
useless=alltests
for i in range(count):
    temp=data[str(i)]
    print("")
    print("")
    print("------------")
    print("Iteration no.",i+1)
    print("Line Coverage",temp['lineCover'])
    print("Branch Coverage",temp['branchCover'])
    print("Total tests run",temp['tests'])
    print("Errors",temp['error'])
    print("Failures",temp['failures'])
    print("Success Rate",temp['succ_rate'])
    alltests=[x for x in alltests if x not in temp['Failure Details']]



print ("")
print ("")
print "Number of useless tests: ",len(alltests)
print ("")
print ("The list of useless tests are:")
print ("")
for i in range(len(alltests)):
    print i+1, ":", str(alltests[i])