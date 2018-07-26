package util;


//import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.AmazonS3;

public class QueryClient {
    private final AmazonS3 amazonS3Client;
    
    public QueryClient(AmazonS3 S3Client) {
        amazonS3Client = S3Client;
    }
    
    
    //Query
    
    
    
    /*
     
    //private final AmazonS3 amazonS3Client;
    private final AmazonKinesis kinesisStream;
    //private final MetricsLogger metricsLogger;
    private final Context context;

    public KinesisPublisher(AmazonKinesis amazonKinesisClient, Context context) {
        //this.amazonS3Client = amazonS3Client;
        this.context = context;
        this.kinesisStream = amazonKinesisClient;
    }

    public void publishToKinesis(@NonNull final ByteBuffer metric) {
        //NEED TO CHANGE THIS BUCKETNAME when officially implement
        final String streamName = "streamtest";
        final String partitionKey = "contentDelivered";
        
        //metrics.forEach(metric -> {
         //   kinesisStream.putRecord(streamName, metric, partitionKey);
         //   context.getLogger().log("\n\nPublished message (" + metric + ") to stream (" + streamName + ")");
       // });
        MessageConverter mess = new MessageConverter();
        kinesisStream.putRecord(streamName, metric, partitionKey);
        context.getLogger().log("\n\nPublished message (" + mess.convertBack(metric) + ") to stream (" + streamName + ")");
    }
}
*/
    
}
