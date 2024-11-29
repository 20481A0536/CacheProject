# README for Cache Implementation Programs

## Overview
This document provides an overview and explanation of two Java programs:
1. **GuavaCacheExample**: A program that demonstrates the usage of Guava's LoadingCache to store and retrieve movie data with caching techniques.
2. **MovieRecommendationCache**: A program that implements custom L1 (recently viewed) and L2 (popular movies) caches using `LinkedHashMap`.

Both programs aim to illustrate caching mechanisms for efficient data retrieval.

---

## Program 1: GuavaCacheExample

### Description
This program utilizes the Guava library to implement a cache for storing and retrieving movie genres. The cache is designed to:
- Store up to 200,000 entries.
- Automatically expire entries 10 minutes after their creation.
- Fetch a default value for keys not present in the cache using `CacheLoader`.

### Features
1. **Cache Initialization**: The `CacheBuilder` is used to configure the cache size and expiration time.
2. **Movie Generation**: Randomly generates 20,000 movie entries with genres assigned from a predefined list.
3. **Performance Measurement**: Measures the time taken to fetch a specific movie from the cache repeatedly.

### Key Methods
- **`CacheBuilder.newBuilder()`**: Configures the cache.
- **`cache.put(key, value)`**: Adds entries to the cache.
- **`cache.get(key)`**: Retrieves entries from the cache, loading default values if the key is not found.

### Example Output
```
Time taken to fetch the movie: 350 nanoseconds
Time taken to fetch the movie: 420 nanoseconds
...
```

---

## Program 2: MovieRecommendationCache

### Description
This program implements two levels of caching:
- **L1 Cache**: Stores the 100 most recently viewed movies.
- **L2 Cache**: Stores up to 1,000 popular movies.

Both caches are implemented using `LinkedHashMap` with the **access-order** configuration to ensure that the least recently accessed entries are evicted when the cache reaches its maximum size.

### Features
1. **Custom Cache Implementation**: Uses `LinkedHashMap` to implement LRU (Least Recently Used) caching for both levels.
2. **Movie Generation**:
   - Generates 2,000 popular movie entries with genres.
   - Generates 100 recently viewed movie entries.
3. **Performance Measurement**: Measures the time taken to fetch a movie from the popular movies cache.

### Key Methods
- **`LinkedHashMap`**: Configured with a custom `removeEldestEntry` method to handle eviction.
- **`recentMovieCache.get(key)`**: Retrieves entries from the L1 cache.
- **`popularMovieCache.get(key)`**: Retrieves entries from the L2 cache.

### Example Output
```
Time taken to fetch movie: 150 nanoseconds
```

---

## Dependencies
- **Guava Library**: Required for `GuavaCacheExample`. Make sure to include the Guava dependency in your project.
  ```xml
  <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
      <version>31.1-jre</version>
  </dependency>
  ```

---

## Instructions to Run
1. Compile the programs using a Java compiler:
   ```bash
   javac -cp guava-31.1-jre.jar GuavaCacheExample.java MovieRecommendationCache.java
   ```
2. Run each program individually:
   ```bash
   java -cp guava-31.1-jre.jar:. GuavaCacheExample
   java MovieRecommendationCache
   ```

---

## Key Takeaways
- **Caching**: Both programs illustrate the importance of caching to improve data retrieval performance.
- **Guava vs Custom Implementation**: The first program uses a library-based approach, while the second provides a manual implementation.
- **Performance Measurement**: The programs demonstrate how to measure and compare the efficiency of cache retrieval.

Feel free to modify the programs to suit your requirements or integrate them into larger applications!
