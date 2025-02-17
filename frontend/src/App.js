import { useState, useEffect } from "react";
import axios from "axios";
import RoomEntry from "./components/RoomEntry";

export default function App() {
    const [rooms, setRooms] = useState([]);
    
    const fetchRooms = async () => {
        try {
            const response = await axios.get("http://localhost:8080/rooms");
            setRooms(response.data);
        } catch (error) {
            console.error("Error fetching rooms", error);
        }
    };

    useEffect(() => {
        fetchRooms();
    }, []);

    const deleteRoom = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/rooms/${id}`);
            fetchRooms();
        } catch (error) {
            console.error("Error deleting room", error);
        }
    };

    return (
        <div className="p-4">
            <h2 className="text-xl font-bold">Hotel Room Management</h2>
            <RoomEntry onEntry={fetchRooms}/>
            <table className="w-full border-collapse border border-gray-300">
                <thead>
                    <tr>
                        <th className="border p-2">ID</th>
                        <th className="border p-2">Room Number</th>
                        <th className="border p-2">Type</th>
                        <th className="border p-2">Status</th>
                        <th className="border p-2">Price</th>
                        <th className="border p-2">Capacity</th>
                        <th className="border p-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {rooms.map((room) => (
                        <tr key={room.id}>
                            <td className="border p-2">{room.roomId}</td>
                            <td className="border p-2">{room.roomNumber}</td>
                            <td className="border p-2">{room.roomType}</td>
                            <td className="border p-2">{room.roomStatus}</td>
                            <td className="border p-2">{room.price}</td>
                            <td className="border p-2">{room.capacity}</td>
                            <td className="border p-2">
                                <button onClick={() => deleteRoom(room.roomId)} className="bg-red-500 text-white px-2 py-1">Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
