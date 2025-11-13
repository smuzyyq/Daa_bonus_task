# Minimum Spanning Tree -- Edge Removal & Recovery

A clean Java implementation demonstrating how to remove an edge from a
Minimum Spanning Tree (MST) and efficiently restore connectivity using
the optimal replacement edge.

This project is created as part of a **Design and Analysis of
Algorithms** bonus task.

------------------------------------------------------------------------

##  Key Features

-   Builds an MST using **Kruskal's algorithm**\
-   Displays the MST before modifications\
-   Removes an edge from the MST\
-   Shows the **connected components** after the split\
-   Finds the **minimum-weight replacement edge** reconnecting the
    components\
-   Outputs the **updated, valid MST**

Everything runs with standard Java --- no external libraries.

------------------------------------------------------------------------

##  Project Structure

    mst/
     ├── Main.java
     ├── Graph.java
     ├── Edge.java
     ├── DisjointSet.java
     └── KruskalMST.java

Each component is separated for clarity: - `Graph` -- stores vertices
and weighted edges\
- `Edge` -- simple model class with Comparable\
- `DisjointSet` -- Union--Find with path compression\
- `KruskalMST` -- MST building + edge removal + replacement\
- `Main` -- executes the demonstration

------------------------------------------------------------------------

##  How It Works

### 1. Build the MST

The program sorts all edges by weight and uses DSU to select edges
safely.

### 2. Remove an Edge

A single edge in the MST is removed, splitting the tree into two
components.

### 3. Detect Components

The DSU recomputes connectivity and outputs all resulting vertex groups.

### 4. Find Replacement Edge

The algorithm scans all graph edges and selects the **lightest edge**
that reconnects the two components.

This ensures the final graph remains a valid MST.

------------------------------------------------------------------------

##  How to Compile & Run

### Clone the project

``` bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
```

### Compile

``` bash
    javac mst/*.java
```

### Run

``` bash
    java mst.Main
```

------------------------------------------------------------------------

## Example Output

    Initial MST:
    0 -- 2 == 4
    1 -- 2 == 2
    2 -- 5 == 2
    3 -- 4 == 3
    2 -- 3 == 3

    MST after removing one edge:
    ...

    Components after edge removal:
    [0, 2, 3]
    [1, 5, 4]

    Replacement edge found: 3 -- 4 == 3

    New MST:
    ...

The output clearly shows: - the original MST\
- the cut\
- the components\
- the replacement edge\
- the restored MST

------------------------------------------------------------------------

##  Requirements

-   **Java 8+**
-   Terminal or IDE capable of compiling Java

