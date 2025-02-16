import { useState } from "react";
import axios from "axios";

function RoomEntry({onEntry}) {
    const [newRoom, setNewRoom] = useState({ roomNumber: "", type: "", status: "", price: "", capacity: "" });

    const handleInputChange = (e) => {
        setNewRoom({ ...newRoom, [e.target.name]: e.target.value });
    };
    const addRoom = async () => {
        try {
            await axios.post("http://localhost:8080/rooms", newRoom);
            onEntry();
            setNewRoom({ roomNumber: "", type: "", status: "", price: "", capacity: "" });
        } catch (error) {
            console.error("Error adding room", error);
        }
    };
    return (<div className="my-4">
                <input type="text" name="roomNumber" placeholder="Room Number" value={newRoom.roomNumber} onChange={handleInputChange} className="border p-1 m-1" />
                <input type="text" name="type" placeholder="Type" value={newRoom.type} onChange={handleInputChange} className="border p-1 m-1" />
                <select name="status" placeholder="Status" value={newRoom.status} onChange={handleInputChange} className="border p-1 m-1" >
                    <option value={'available'}>available</option>
                    <option value={'unavailable'}>unavailable</option>
                </select>
                <input type="number" name="price" placeholder="Price" value={newRoom.price} onChange={handleInputChange} className="border p-1 m-1" />
                <input type="number" name="capacity" placeholder="Capacity" value={newRoom.capacity} onChange={handleInputChange} className="border p-1 m-1" />
                <button onClick={addRoom} className="bg-blue-500 text-white px-4 py-2 m-1">Add Room</button>
            </div>)
}

export default RoomEntry