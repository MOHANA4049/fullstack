import AWS, {config} from 'aws-sdk';
const config = {
    bucketName: process.env.AWS_BUCKET_NAME,
    dirName: "user-profiles",
    region: process.env.AWS_BUCKET_REGION,
    accessKeyId: process.env.AWS_ACCESS_KEY_ID,
    secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY
}

const S3Uploader = () => {

const config = {
    bucketName: import.meta.env.AWS_BUCKET_NAME,
    dirName: "user-profiles",
    region: import.meta.env.AWS_BUCKET_REGION,
    accessKeyId: import.meta.env.AWS_ACCESS_KEY_ID,
    secretAccessKey: import.meta.env.AWS_SECRET_ACCESS_KEY
}

const handleFileUpload = (event) => {
    const file = event.target.files[0];
    if(!config.bucketName||!config.region ||!config.accessKeyId||!config.secretAccessKey){
        console.error("AWS configuration is incomplete.");
        return;
    }
    // Initializing our aws
    AWS.config.update({
        accessKeyId: config.accessKeyId,
        secretAccessKey: config.secretAccessKey,
        region: config.region
    })

    // Creating new instance
    const S3 = new AWS.S3();
    const reader=new FileReader();
    reader.onload=()=>{
        const fileBuffer=reader.result;
        S3.upload(
            {
                Bucket:config.bucketName,
                Key:`${config.dirName}/${file.name}`,
                Body:fileBuffer,
                ACL:'public-read',
                ContentType:'image/svg+xml'
            },(err,uploadData)=>{
                if(err){
                    console.error(err);
                }
                else
                    console.log(uploadData);
            }
        );
    };
    reader.readAsArrayBuffer(file);
};

return (
    <div>
        <input type="file" onChange={handleFileUpload} />
        <img src={data} alt="uploaded data"></img>
    </div>
)
}

export default S3Uploader;