import { Link } from "react-router-dom";

export default function CheckInDone(){
    return <>
        <div className="checkin-done ">
            <div className="">
            <h1 className="display-2">
                Checkin Successfull
            </h1>
            </div>
            <center>
            <Link to={'/'} ><button className="btn btn-outline-primary">Home</button></Link>
            </center>
        </div>
    </>
}