import { useState } from "react";
import api from "../api";
import { Link, Navigate } from "react-router-dom";

export default function Home(){
    return <>    
    
        <main>
            <div className="row">
        <div className="Banner col-md-6">
            <img src="Images/silhouette-young-man-background-milky-way-galaxy-bright-star-dark-sky-tone.jpg" />
            <div className=""></div>
        </div>
        <div className="col-md-6 banner-2">
            <h1 className="display-1">Go further,</h1>
            <h1 className="display-1 mb-5">get closer</h1>
            <p>Millions of cheap flights. One simple search.</p>
            
            <Link to={"/login"}><button className="btn btn-info mt-3">Search Flights</button></Link>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link to={"/check-in"}><button className="btn btn-secondary mt-3">Check In</button></Link>
            
        </div>
        </div>
        
        </main>
        
  
    </>
}