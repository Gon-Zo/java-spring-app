import React from "react";
import {ResponsiveLine} from "@nivo/line";

export default () =>{
   return(
      <TestChart data={data}/>
   )
}

let data = [
    {
        "id": "japan",
        "color": "hsl(207, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 126
            },
            {
                "x": "helicopter",
                "y": 61
            },
            {
                "x": "boat",
                "y": 220
            },
            {
                "x": "train",
                "y": 111
            },
            {
                "x": "subway",
                "y": 199
            },
            {
                "x": "bus",
                "y": 177
            },
            {
                "x": "car",
                "y": 135
            },
            {
                "x": "moto",
                "y": 204
            },
            {
                "x": "bicycle",
                "y": 52
            },
            {
                "x": "horse",
                "y": 61
            },
            {
                "x": "skateboard",
                "y": 219
            },
            {
                "x": "others",
                "y": 211
            }
        ]
    },
    {
        "id": "france",
        "color": "hsl(130, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 24
            },
            {
                "x": "helicopter",
                "y": 269
            },
            {
                "x": "boat",
                "y": 103
            },
            {
                "x": "train",
                "y": 254
            },
            {
                "x": "subway",
                "y": 152
            },
            {
                "x": "bus",
                "y": 12
            },
            {
                "x": "car",
                "y": 20
            },
            {
                "x": "moto",
                "y": 54
            },
            {
                "x": "bicycle",
                "y": 255
            },
            {
                "x": "horse",
                "y": 273
            },
            {
                "x": "skateboard",
                "y": 202
            },
            {
                "x": "others",
                "y": 200
            }
        ]
    },
    {
        "id": "us",
        "color": "hsl(315, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 38
            },
            {
                "x": "helicopter",
                "y": 95
            },
            {
                "x": "boat",
                "y": 127
            },
            {
                "x": "train",
                "y": 207
            },
            {
                "x": "subway",
                "y": 175
            },
            {
                "x": "bus",
                "y": 54
            },
            {
                "x": "car",
                "y": 282
            },
            {
                "x": "moto",
                "y": 229
            },
            {
                "x": "bicycle",
                "y": 170
            },
            {
                "x": "horse",
                "y": 106
            },
            {
                "x": "skateboard",
                "y": 103
            },
            {
                "x": "others",
                "y": 97
            }
        ]
    },
    {
        "id": "germany",
        "color": "hsl(87, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 90
            },
            {
                "x": "helicopter",
                "y": 298
            },
            {
                "x": "boat",
                "y": 247
            },
            {
                "x": "train",
                "y": 69
            },
            {
                "x": "subway",
                "y": 270
            },
            {
                "x": "bus",
                "y": 68
            },
            {
                "x": "car",
                "y": 59
            },
            {
                "x": "moto",
                "y": 251
            },
            {
                "x": "bicycle",
                "y": 70
            },
            {
                "x": "horse",
                "y": 40
            },
            {
                "x": "skateboard",
                "y": 64
            },
            {
                "x": "others",
                "y": 203
            }
        ]
    },
    {
        "id": "norway",
        "color": "hsl(193, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 293
            },
            {
                "x": "helicopter",
                "y": 267
            },
            {
                "x": "boat",
                "y": 46
            },
            {
                "x": "train",
                "y": 253
            },
            {
                "x": "subway",
                "y": 212
            },
            {
                "x": "bus",
                "y": 126
            },
            {
                "x": "car",
                "y": 185
            },
            {
                "x": "moto",
                "y": 42
            },
            {
                "x": "bicycle",
                "y": 7
            },
            {
                "x": "horse",
                "y": 169
            },
            {
                "x": "skateboard",
                "y": 64
            },
            {
                "x": "others",
                "y": 293
            }
        ]
    }
]

function TestChart(props) {
    return(
        <ResponsiveLine
            data={data}
            margin={{ top: 10, right: 110, bottom: 50, left: 60 }}
            xScale={{ type: 'point' }}
            yScale={{ type: 'linear', min: 'auto', max: 'auto', stacked: true, reverse: false }}
            axisTop={null}
            axisRight={null}
            axisBottom={{
                orient: 'bottom',
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: 'transportation',
                legendOffset: 36,
                legendPosition: 'middle'
            }}
            axisLeft={{
                orient: 'left',
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: 'count',
                legendOffset: -40,
                legendPosition: 'middle'
            }}
            colors={{ scheme: 'nivo' }}
            pointSize={10}
            pointColor={{ theme: 'background' }}
            pointBorderWidth={2}
            pointBorderColor={{ from: 'serieColor' }}
            pointLabel="y"
            pointLabelYOffset={-12}
            useMesh={true}
            legends={[
                {
                    anchor: 'bottom-right',
                    direction: 'column',
                    justify: false,
                    translateX: 100,
                    translateY: 0,
                    itemsSpacing: 0,
                    itemDirection: 'left-to-right',
                    itemWidth: 80,
                    itemHeight: 20,
                    itemOpacity: 0.75,
                    symbolSize: 12,
                    symbolShape: 'circle',
                    symbolBorderColor: 'rgba(0, 0, 0, .5)',
                    effects: [
                        {
                            on: 'hover',
                            style: {
                                itemBackground: 'rgba(0, 0, 0, .03)',
                                itemOpacity: 1
                            }
                        }
                    ]
                }
            ]}
        />
    )
}

