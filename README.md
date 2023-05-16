# City Connections

problem Statement

Transfer between one to multiple cities

## How to run

jar can be found in  [target](https://github.com/praveen2710/City-Connections/tree/master/target) along with a sample [cities.txt](https://github.com/praveen2710/City-Connections/blob/master/target/cities.txt)

`java -jar City-Connections-1.0-SNAPSHOT.jar <fileName> <cityOne> <cityTwo>`

Args
* `<fileName>` : a text file mentioning two connected cities in comma separated fashion
* `<cityOne>` : The source city from which connection is being verified.
* `<cityTwo>` : The destionation city which is being tried to reach.

## Examples 

``java -jar City-Connections-1.0-SNAPSHOT.jar cities.txt Boston Hartford``

## Implementation Details

### Assumptions
* Connection between two cities is undirected graph vertex. i.e Bostion, New York means we can travel from Boston to New York and vice versa.
* Every line in file will contain two cities only comma separated .
```text
Philadelphia, Pittsburgh
Boston, New York
```

### Implementation Details
* Used a BFS to find connection between two cities not connected directly.
* If cityOne and cityTwo are same we will return a response without processing connections text file.
* If two cities in question are connected directly we stop processing of connection file as soon as it is found since further processing of text file is not required

### TODO future improvement
* Add logging 
* As it stands this needs to process connections text file to check conneciton between every two cities. Make changes such that we only need to process file once and verify multiple pair of cities.