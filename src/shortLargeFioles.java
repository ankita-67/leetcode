import java.io.*;
import java.util.*;
public class shortLargeFioles {



        public static void main(String[] args) throws IOException {
            String inputFile = "large_data.txt";
            String outputFile = "sorted_data.txt";
            externalSort(inputFile, outputFile);
        }

        public static void externalSort(String inputFile, String outputFile) throws IOException {
            // Step 1: Split the data into smaller chunks, sort and write to disk
            int chunkCount = splitAndSortChunks(inputFile);

            // Step 2: Merge the sorted chunks into a final sorted file
            mergeSortedChunks(chunkCount, outputFile);

            // Step 3: Cleanup the temporary chunk files
            cleanup(chunkCount);
        }

        // Step 1: Split and sort chunks
        public static int splitAndSortChunks(String inputFile) throws IOException {
            int chunkCount = 0;
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            List<String> chunkData = new ArrayList<>();
            String line;
            int chunkSizeLimit = 500 * 1024 * 1024;  // 500 MB limit per chunk
            int currentChunkSize = 0;

            while ((line = reader.readLine()) != null) {
                // Read the data and accumulate until we hit the chunk size limit
                chunkData.add(line);
                currentChunkSize += line.length();

                // If the chunk size exceeds the limit, process the chunk
                if (currentChunkSize >= chunkSizeLimit) {
                    Collections.sort(chunkData);
                    writeChunkToFile(chunkData, chunkCount);
                    chunkData.clear();
                    currentChunkSize = 0;
                    chunkCount++;
                }
            }

            // Handle the last chunk if it has remaining data
            if (!chunkData.isEmpty()) {
                Collections.sort(chunkData);
                writeChunkToFile(chunkData, chunkCount);
                chunkCount++;
            }

            reader.close();
            return chunkCount;
        }

        private static void writeChunkToFile(List<String> chunkData, int chunkCount) throws IOException {
            String chunkFileName = "chunk_" + chunkCount + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFileName));
            for (String line : chunkData) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }

        // Step 2: Merge sorted chunks
        public static void mergeSortedChunks(int chunkCount, String outputFile) throws IOException {
            List<BufferedReader> readers = new ArrayList<>();
            for (int i = 0; i < chunkCount; i++) {
                readers.add(new BufferedReader(new FileReader("chunk_" + i + ".txt")));
            }

            PriorityQueue<ChunkEntry> minHeap = new PriorityQueue<>(Comparator.comparing(chunk -> chunk.line));
            // Initialize the heap with the first line of each chunk
            for (int i = 0; i < chunkCount; i++) {
                String line = readers.get(i).readLine();
                if (line != null) {
                    minHeap.add(new ChunkEntry(line, i));
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            while (!minHeap.isEmpty()) {
                ChunkEntry entry = minHeap.poll();
                writer.write(entry.line);
                writer.newLine();

                // If there's more data in the chunk, read the next line and add to the heap
                String nextLine = readers.get(entry.chunkIndex).readLine();
                if (nextLine != null) {
                    minHeap.add(new ChunkEntry(nextLine, entry.chunkIndex));
                }
            }

            writer.close();
            for (BufferedReader reader : readers) {
                reader.close();
            }
        }

        // Step 3: Cleanup the temporary chunk files
        public static void cleanup(int chunkCount) {
            for (int i = 0; i < chunkCount; i++) {
                new File("chunk_" + i + ".txt").delete();
            }
        }

        // Helper class to store data in the min-heap
        static class ChunkEntry {
            String line;
            int chunkIndex;

            ChunkEntry(String line, int chunkIndex) {
                this.line = line;
                this.chunkIndex = chunkIndex;
            }
        }
    }
