import React, { useEffect, useState } from "react";

const issues = [
  {
    id: 1,
    description: "Fix login page layout",
    targetDate: new Date(2023, 6, 30),
    done: false,
  },
  {
    id: 2,
    description: "Implement search functionality",
    targetDate: new Date(2023, 7, 10),
    done: true,
  },
  // Add more issues here
];

const formatDate = (date) => {
  const dateObject = new Date(date);
  const options = { month: "2-digit", day: "2-digit", year: "2-digit" };
  return dateObject.toLocaleDateString(undefined, options);
};

const IssueDashboard = () => {
  const [issues, setIssues] = useState([]);

  useEffect(() => {
    const fetchIssues = async () => {
      try {
        const response = await fetch("http://localhost:8080/issues/username", {
          headers: {
            Origin: "http://localhost:3000",
          },
        });
        if (!response.ok) {
          throw new Error("Failed to fetch issues");
        }
        const data = await response.json();
        setIssues(data);
      } catch (error) {
        console.error("Error fetching issues:", error);
      }
    };

    fetchIssues();
  }, []);

  return (
    <div className="container mx-auto mt-8">
      <h1 className="text-2xl font-bold mb-4">Issue Dashboard</h1>
      <table className="table-auto w-full">
        <thead>
          <tr>
            <th className="px-4 py-2">ID</th>
            <th className="px-4 py-2">Description</th>
            <th className="px-4 py-2">Target Date</th>
            <th className="px-4 py-2">Done Status</th>
          </tr>
        </thead>
        <tbody>
          {issues.map((issue) => (
            <tr key={issue.id}>
              <td className="border px-4 py-2">{issue.id}</td>
              <td className="border px-4 py-2">{issue.description}</td>
              <td className="border px-4 py-2">
                {formatDate(issue.targetDate)}
              </td>
              <td className="border px-4 py-2">
                {issue.done ? "Done" : "Not Done"}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default IssueDashboard;
